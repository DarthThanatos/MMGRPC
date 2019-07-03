package client

import io.grpc.stub.StreamObserver
import server.*
import server.Util.Companion.newCombinationRequest
import java.util.concurrent.CountDownLatch

interface Verifier {

    fun waitForGuesser(
        combinationArray: Array<Color>,
        player: Player,
        blockingStub: GreeterGrpc.GreeterBlockingStub
    ): Player

    fun subscribeForGuesses(
        player: Player,
        asynchBlock: GreeterGrpc.GreeterStub,
        blockingStub: GreeterGrpc.GreeterBlockingStub,
        latch:CountDownLatch,
        interaction: (userName: String) -> Array<VerificationMarker>
    )
}

class VerifierImpl: Verifier{

    private fun newVerification(player: Player, markers: Array<VerificationMarker>) =
        Verification.newBuilder().setPlayer(player).setFirst(markers[0]).setSecond(markers[1]).setThird(markers[2]).setFourth(markers[3]).setEndGame(false).build()

    override fun subscribeForGuesses(
        player: Player,
        asynchBlock: GreeterGrpc.GreeterStub,
        blockingStub: GreeterGrpc.GreeterBlockingStub,
        latch:CountDownLatch,
        interaction: (userName: String) -> Array<VerificationMarker>
    ) {
        asynchBlock.getGuesses(player, object: StreamObserver<Combination>{
            override fun onNext(value: Combination) {
                println("Got combination: $value")
                val markers = interaction(player.playerName)
                println(blockingStub.verify(newVerification(player, markers)))
            }

            override fun onError(t: Throwable) {
                t.printStackTrace()
            }

            override fun onCompleted() {
                println("finished")
                latch.countDown()
            }

        })
    }

    override fun waitForGuesser(
        combinationArray: Array<Color>,
        player: Player,
        blockingStub: GreeterGrpc.GreeterBlockingStub
    ) = blockingStub.waitForGuesser(newCombinationRequest(combinationArray, player))

}