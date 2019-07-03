package server

import io.grpc.stub.StreamObserver
import java.util.*

interface OpponentsMatcher{
    fun waitForGuesser(request: Combination, responseObserver: StreamObserver<Player>)
    fun waitForVerifier(request: Player, responseObserver: StreamObserver<Player>)
}

data class WaiterDescription(val waiter: PlayerData, val waiterObserver: StreamObserver<Player>)

class OpponentsMatcherImpl(private val globalManager: GamesGlobalManager): OpponentsMatcher{

    //game uuid -> waiter data
    private val waitingForPair: HashMap<UUID, WaiterDescription> = HashMap()

    private fun onAuthenticatedVerifier(request: Player, responseObserver: StreamObserver<Player>) {
        val uuid = UUID.fromString(request.gameId)
        waitingForPair[uuid] = WaiterDescription(PlayerConverter.playerToPlayerData(request), responseObserver)
    }

    private fun onAuthenticatedGuesser(request: Player, responseObserver: StreamObserver<Player>) {
        val uuid = UUID.fromString(request.gameId)
        val waiterDescription = waitingForPair[uuid]!!
        waiterDescription.waiterObserver.onNext(request)
        responseObserver.onNext(PlayerConverter.playerDataToPlayer(waiterDescription.waiter))
        waiterDescription.waiterObserver.onCompleted()
        responseObserver.onCompleted()
    }

    @Synchronized
    override fun waitForGuesser(request: Combination, responseObserver: StreamObserver<Player>) {
        Util.authenticate(request.player, request.player, responseObserver, Role.VERIFIER, globalManager, this::onAuthenticatedVerifier)
        //TO-DO decide what happens with the initialized color combination
        println("Selected combination for game: ${request.player.gameId}: ${request.first.name} ${request.second.name} ${request.third.name} ${request.fourth.name}")
    }

    @Synchronized
    override fun waitForVerifier(request: Player, responseObserver: StreamObserver<Player>) {
        Util.authenticate(request, request, responseObserver, Role.GUESSER, globalManager, this::onAuthenticatedGuesser)
    }
}