package client


import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import server.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


internal val helloSayer = HelloSayerImpl()
internal val gameRequester = GameRequesterImpl()
internal val userInteraction = UserInteractionImpl()
internal val verifier = VerifierImpl()
internal val guesser = GuesserImpl()

/**
 * A simple client that requests a greeting from the [MasterMindServer].
 */
class MasterMindClient
/** Construct client for accessing RouteGuide server using the existing channel.  */
internal constructor(private val channel: ManagedChannel):
    HelloSayer by helloSayer,
    GameRequester by gameRequester,
    UserInteraction by userInteraction,
    Verifier by verifier,
    Guesser by guesser {

    private val blockingStub: GreeterGrpc.GreeterBlockingStub
            = GreeterGrpc.newBlockingStub(channel)
        get() = field

    private val asynchStub = GreeterGrpc.newStub(channel)
        get() = field

    /** Construct client connecting to HelloWorld server at `host:port`.  */
    constructor(host: String, port: Int) : this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build())


    @Throws(InterruptedException::class)
    fun shutdown() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }


    companion object {

        @JvmStatic
        private fun probeGameDescription(userName:String, gameName:String, client: MasterMindClient): GameDescription{
            val gamesByName = client.getGamesByName(gameName, client.blockingStub)
            val index = client.getGameIndex(userName, gamesByName)
            return gamesByName.gamesList.get(index)
        }


        @JvmStatic
        private fun verifier(player:Player, client: MasterMindClient){
            val msg = "please type a 4-letter combination of colors to guess by your opponent"
            val colorsArray = client.getSecretCombination(player.playerName, msg)
            println("Waiting for guesser to arrive")
            val opponent = client.waitForGuesser(colorsArray, player, client.blockingStub)
            client.keepAlive(player, client.asynchStub)
            println("Guesser has arrived: ${opponent.playerName}, ${opponent.playerId}, ${opponent.role}, ${opponent.gameId}")
            val latch = CountDownLatch(1)
            val verifyLogMsg = "please type a 4-letter combination of verification markers"
            client.subscribeForGuesses(player, client.asynchStub, client.blockingStub, latch, {userName -> client.getVerificationCombination(userName, verifyLogMsg)})
            latch.await()
        }

        @JvmStatic
        private fun guesser(player: Player, client: MasterMindClient){
            println("Waiting for verifier to arrive")
            val opponent = client.waitForVerifier(player, client.blockingStub)
            client.keepAlive(player, client.asynchStub)
            println("Verifier has arrived: ${opponent.playerName}, ${opponent.playerId}, ${opponent.role}, ${opponent.gameId}")
            while (true){
                val msg = "please type a 4-letter combination of colors"
                val colorsArray = client.getSecretCombination(player.playerName, msg)
                val verification = client.guess(colorsArray, player, client.blockingStub)
                println("Verification: ${verification.first.name}, ${verification.second.name}, ${verification.third.name}, ${verification.fourth.name}")
                if (verification.endGame){
                    break
                }
            }

        }

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val client = MasterMindClient("localhost", 50051)
            try {
                val userName = client.askUserName()
                val shouldCreate = client.askIfCreateGame(userName)
                val gameName = client.askGameName(userName)
                val gameDescription =
                    if (shouldCreate)client.createGame(gameName, client.blockingStub)
                    else probeGameDescription(userName, gameName, client)
                val player = client.joinGame(userName, gameDescription, client.blockingStub)
                println("${player.playerName}, ${player.playerId}, ${player.role}, ${player.gameId}")
                if (player.role == Role.VERIFIER) verifier(player, client)
                else guesser(player, client)
            } catch (e: io.grpc.StatusRuntimeException){
                println(e.status.description)
            }
            finally {
                client.shutdown()
            }
        }
    }
}

fun main(args: Array<String>){
    MasterMindClient.main(args)
}
