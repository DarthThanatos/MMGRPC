package server

import io.grpc.stub.StreamObserver
import java.util.*
import java.util.concurrent.ConcurrentHashMap

interface KeepAlive{
    fun keepAlive(responseObserver: StreamObserver<Player>): StreamObserver<Player>
}

class KeepAliveImpl(private val globalManager: GamesGlobalManager): KeepAlive{

    // player uuid -> timer/observer
    private val keepAliveTimers = ConcurrentHashMap<UUID, Pair<Timer, KeepAliveTimerTask>>()
    private val keepAliveObservers = ConcurrentHashMap<UUID, StreamObserver<Player>>()

    override fun keepAlive(responseObserver: StreamObserver<Player>): StreamObserver<Player> =
        KeepAliveObserver(responseObserver, keepAliveObservers, keepAliveTimers, globalManager)
}

internal class KeepAliveTimerTask(
    private val playerData: PlayerData,
    private val opponentUUID: UUID,
    private val keepAliveObservers: ConcurrentHashMap<UUID, StreamObserver<Player>>

): TimerTask() {

    override fun run() {
        val opponentObserver = keepAliveObservers[opponentUUID]
        println("${playerData.name} - sending exit to $opponentUUID, task hash: ${this.hashCode()}")
        opponentObserver?.onNext(PlayerConverter.playerDataToPlayer(playerData))
    }

}

internal class KeepAliveObserver(
    private val responseObserver: StreamObserver<Player>,
    private val keepAliveObservers: ConcurrentHashMap<UUID, StreamObserver<Player>>,
    private val keepAliveTimers:ConcurrentHashMap<UUID, Pair<Timer, KeepAliveTimerTask>>,
    private val globalManager: GamesGlobalManager
): StreamObserver<Player> {

    private lateinit var playerData: PlayerData

    override fun onNext(value: Player) {
        val playerUuid = UUID.fromString(value.playerId)
        val gameId = UUID.fromString(value.gameId)
        val opponentUUID = globalManager.opponentUUID(gameId, playerUuid)
        if (!keepAliveObservers.containsKey(playerUuid)){
            keepAliveObservers[playerUuid] = responseObserver
        }
        if(keepAliveTimers.containsKey(playerUuid)){
            val timer_task = keepAliveTimers[playerUuid]!!
            timer_task.first.cancel()
            timer_task.second.cancel()
        }
        val timer = Timer()
        playerData = PlayerConverter.playerToPlayerData(value)
        val task = KeepAliveTimerTask(playerData, opponentUUID, keepAliveObservers)
        timer.schedule(task,3000)
        keepAliveTimers[playerUuid] = Pair(timer, task)
    }

    override fun onError(t: Throwable) {
        println("error ${this.hashCode()}")
        println(t.message)
    }

    override fun onCompleted() {
        println("${playerData.name} on completed")
        responseObserver.onCompleted()
    }

}
