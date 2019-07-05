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

    private fun onAuthenticatedGuesser(combination: Combination, responseObserver: StreamObserver<Verification>){
        val uuid = UUID.fromString(combination.player.gameId)
        globalManager.gameById(uuid)!!.gameStatistics.addGuess(combination)
        guessersDescriptions[uuid] = responseObserver
        val verifierObserver = vericatorsDescriptions[uuid]!!
        verifierObserver.onNext(combination)
    }

    override fun verify(request: Verification, responseObserver: StreamObserver<VerifyAck>) {
        Util.authenticate(request, request.player, responseObserver, Role.VERIFIER, globalManager, this::onAuthenticatedVerifier)
    }

    private fun newVerifyAck() =
        VerifyAck.newBuilder().setMessage("Wait for guesser response").build()

    private fun onAuthenticatedVerifier(verification: Verification, responseObserver: StreamObserver<VerifyAck>){
        val uuid = UUID.fromString(verification.player.gameId)
        val gameEnd = onRoundEnd(verification, uuid)
        updateVerifier(gameEnd, responseObserver, uuid)
        updateGuesser(verification, gameEnd, uuid)
    }

    private fun onRoundEnd(verification: Verification, uuid: UUID): Boolean {
        val gameStatistics = globalManager.gameById(uuid)!!.gameStatistics
        gameStatistics.addVerificationAndIncrementRound(verification)
        return gameStatistics.gameOver(verification)
    }

    private fun updateVerifier(gameEnd: Boolean, responseObserver: StreamObserver<VerifyAck>, uuid: UUID){
        if(gameEnd){
            val longTimeObserver = vericatorsDescriptions[uuid]!!
            vericatorsDescriptions.remove(uuid)
            longTimeObserver.onCompleted()
        }
        responseObserver.onNext(newVerifyAck())
        responseObserver.onCompleted()
    }

    private fun updateGuesser(verification: Verification, gameEnd: Boolean, uuid: UUID){
        val guesserObserver = guessersDescriptions[uuid]!!
        guessersDescriptions.remove(uuid)
        val updatedVerification = verification.toBuilder().setEndGame(gameEnd).build()
        guesserObserver.onNext(updatedVerification)
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