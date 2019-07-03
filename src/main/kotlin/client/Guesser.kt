package client
import server.*

interface Guesser{
    fun waitForVerifier(player: Player, blockingStub: GreeterGrpc.GreeterBlockingStub): Player
    fun guess(colorsArr: Array<Color>, player: Player, blockingStub: GreeterGrpc.GreeterBlockingStub): Verification
}

class GuesserImpl: Guesser {

    override fun guess(
        colorsArr: Array<Color>,
        player: Player,
        blockingStub: GreeterGrpc.GreeterBlockingStub
    ): Verification = blockingStub.guess(Util.newCombinationRequest(colorsArr, player))

    override fun waitForVerifier(
        player: Player,
        blockingStub: GreeterGrpc.GreeterBlockingStub
    ) = blockingStub.waitForVerifier(player)

}

