package server

import io.grpc.stub.StreamObserver
import java.util.*

interface MatchManager{
    fun getGuesses(request: Player, responseObserver: StreamObserver<Combination>)
    fun verify(request: Verification, responseObserver: StreamObserver<VerifyAck>)
    fun guess(request: Combination, responseObserver: StreamObserver<Verification>)
}

class MatchManagerImpl(private val globalManager: GamesGlobalManager): MatchManager{

    private val guessersDescriptions = HashMap<UUID, StreamObserver<Verification>>()
    private val vericatorsDescriptions = HashMap<UUID, StreamObserver<Combination>>()

    override fun guess(request: Combination, responseObserver: StreamObserver<Verification>) {
        Util.authenticate(request, request.player, responseObserver, Role.GUESSER, globalManager, this::onAuthenticatedGuesser)
    }

    private fun onAuthenticatedGuesser(request: Combination, responseObserver: StreamObserver<Verification>){
        val uuid = UUID.fromString(request.player.gameId)
        guessersDescriptions[uuid] = responseObserver
        val verifierObserver = vericatorsDescriptions[uuid]!!
        verifierObserver.onNext(request)
    }

    override fun verify(request: Verification, responseObserver: StreamObserver<VerifyAck>) {
        Util.authenticate(request, request.player, responseObserver, Role.VERIFIER, globalManager, this::onAuthenticatedVerifier)
    }

    private fun newVerifyAck() =
        VerifyAck.newBuilder().setMessage("Wait for guesser response").build()

    private fun onAuthenticatedVerifier(request: Verification, responseObserver: StreamObserver<VerifyAck>){
        val uuid = UUID.fromString(request.player.gameId)
        responseObserver.onNext(newVerifyAck())
        responseObserver.onCompleted()
        val guesserObserver = guessersDescriptions[uuid]!!
        guessersDescriptions.remove(uuid)
        guesserObserver.onNext(request)
        guesserObserver.onCompleted()
    }

    override fun getGuesses(request: Player, responseObserver: StreamObserver<Combination>) {
        Util.authenticate(request, request, responseObserver, Role.VERIFIER, globalManager, this::onAuthenticatedVerifierAsynch)
    }

    private fun onAuthenticatedVerifierAsynch(request: Player, responseObserver: StreamObserver<Combination>){
        val uuid = UUID.fromString(request.gameId)
        vericatorsDescriptions[uuid] = responseObserver
    }
}