package server

import io.grpc.stub.StreamObserver
import java.util.*
import kotlin.collections.HashMap

interface OpponentsMatcher{
    fun waitForGuesser(request: Combination, responseObserver: StreamObserver<Player>)
    fun waitForVerifier(request: Player, responseObserver: StreamObserver<Player>)
}

data class WaiterDescription(val waiter: PlayerData, val waiterObserver: StreamObserver<Player>)

class OpponentsMatcherImpl(private val globalManager: GamesGlobalManager): OpponentsMatcher{

    //game uuid -> waiter data
    private val waitingForPair: HashMap<UUID, WaiterDescription> = HashMap()

    @Synchronized
    private fun onAuthenticated(request: Player, responseObserver: StreamObserver<Player>){
        val uuid = UUID.fromString(request.gameId)
        if(!waitingForPair.containsKey(uuid)){
            waitingForPair[uuid] = WaiterDescription(PlayerConverter.playerToPlayerData(request), responseObserver)
        }
        else{
            val waiterDescription = waitingForPair[uuid]!!
            waitingForPair.remove(uuid)
            waiterDescription.waiterObserver.onNext(request)
            responseObserver.onNext(PlayerConverter.playerDataToPlayer(waiterDescription.waiter))
            waiterDescription.waiterObserver.onCompleted()
            responseObserver.onCompleted()
        }
    }

    override fun waitForGuesser(request: Combination, responseObserver: StreamObserver<Player>) {
        Util.authenticate(request.player, request.player, responseObserver, Role.VERIFIER, globalManager, this::onAuthenticated)
        globalManager.gameById(UUID.fromString(request.player.gameId))!!.gameStatistics.secretCombination = request
    }

    override fun waitForVerifier(request: Player, responseObserver: StreamObserver<Player>) {
        Util.authenticate(request, request, responseObserver, Role.GUESSER, globalManager, this::onAuthenticated)
    }
}