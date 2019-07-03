package server


import io.grpc.Server
import io.grpc.ServerBuilder
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger

internal val globalManager = GamesGlobalManagerImpl()
internal val opponentsMatcher = OpponentsMatcherImpl(globalManager)
internal val helloSayer = HelloSayerImpl()
internal val matchManager = MatchManagerImpl(globalManager)

class MasterMindServer {

    private var server: Server? = null

    @Throws(IOException::class)
    private fun start() {
        /* The port on which the server should run */
        val port = 50051
        server = ServerBuilder.forPort(port)
            .addService(GreeterImpl())
            .build()
            .start()
        logger.log(Level.INFO, "Server started, listening on {0}", port)
        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down")
                this@MasterMindServer.stop()
                System.err.println("*** server shut down")
            }
        })
    }

    private fun stop() {
        server?.shutdown()
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    @Throws(InterruptedException::class)
    private fun blockUntilShutdown() {
        server?.awaitTermination()
    }

    @Suppress("DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
    internal class GreeterImpl : GreeterGrpc.GreeterImplBase(),
        HelloSayer by helloSayer,
        GamesGlobalManager by globalManager,
        OpponentsMatcher by opponentsMatcher,
        MatchManager by matchManager { }

    companion object {
        private val logger = Logger.getLogger(MasterMindServer::class.java.name)

        /**
         * Main launches the server from the command line.
         */
        @Throws(IOException::class, InterruptedException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            println("Starting server")
            val server = MasterMindServer()
            server.start()
            server.blockUntilShutdown()
        }
    }
}
