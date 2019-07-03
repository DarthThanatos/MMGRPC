package client

import server.*

interface GameRequester{
    fun createGame(gameName: String, blockingStub: GreeterGrpc.GreeterBlockingStub): GameDescription
    fun getGamesByName(gameName: String, blockingStub: GreeterGrpc.GreeterBlockingStub): GamesByName
    fun joinGame(userName: String, gameDescription: GameDescription, blockingStub: GreeterGrpc.GreeterBlockingStub): Player
}

class GameRequesterImpl: GameRequester{

    private fun getGamesRequest(gameName: String) =
        GameDescription.newBuilder()
            .setGameName(gameName)
            .build()

    override fun getGamesByName(gameName: String, blockingStub: GreeterGrpc.GreeterBlockingStub): GamesByName =
        blockingStub.getGamesByName(getGamesRequest(gameName))

    private fun newGameRequest(gameName: String) =
        GameDescription.newBuilder()
            .setGameName(gameName)
            .build()

    override fun createGame(gameName: String, blockingStub: GreeterGrpc.GreeterBlockingStub) =
        blockingStub.createGame(newGameRequest(gameName))

    private fun newJoinRequest(userName: String, gameDescription: GameDescription) =
        Player.newBuilder()
            .setPlayerName(userName)
            .setGameId(gameDescription.gameId)
            .build()

    override fun joinGame(userName: String, gameDescription: GameDescription, blockingStub: GreeterGrpc.GreeterBlockingStub) =
        blockingStub.joinGame(newJoinRequest(userName, gameDescription))

}