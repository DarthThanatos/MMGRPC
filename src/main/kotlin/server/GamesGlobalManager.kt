package server

import io.grpc.stub.StreamObserver
import server.PlayerConverter.Companion.newPlayer
import server.PlayerConverter.Companion.playerDataToPlayer
import java.lang.Exception
import java.util.*

data class GameData(
    val verifier: PlayerData = PlayerData(),
    val guesser: PlayerData = PlayerData(),
    val creationDate: Date,
    val gameId: UUID,
    val gameName: String
)

interface GamesGlobalManager{
    fun createGame(request: GameDescription, responseObserver: StreamObserver<GameDescription>)
    fun joinGame(request: Player, responseObserver: StreamObserver<Player>)
    fun getGamesByName(request: GameDescription, responseObserver: StreamObserver<GamesByName>)
    fun gameById(id: UUID): GameData?
}

class GamesGlobalManagerImpl: GamesGlobalManager{

    private val games = HashMap<UUID, GameData>()

    override fun gameById(id: UUID) = games[id]

    private fun newGameData(request: GameDescription) =
        GameData(gameName = request.gameName, gameId = UUID.randomUUID(), creationDate = Date())

    private fun gameDataToGameDescription(gameData: GameData) = GameDescription.newBuilder()
        .setCreationDate(gameData.creationDate.toString())
        .setGameId(gameData.gameId.toString())
        .setGameName(gameData.gameName)
        .setVerifier(playerDataToPlayer(gameData.verifier))
        .setGuesser(playerDataToPlayer(gameData.guesser))
        .build()

    override fun createGame(request: GameDescription, responseObserver: StreamObserver<GameDescription>) {
        val game = newGameData(request)
        val reply = gameDataToGameDescription(game)
        games[game.gameId] = game
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }

    private fun updateGameData(gameData: GameData, playerData: PlayerData){
        val updatedGame =
            if(gameData.verifier.role == Role.DEFAULT) gameData.copy(verifier = playerData)
            else gameData.copy(guesser = playerData)
        games[gameData.gameId] = updatedGame
    }

    @Throws(Exception::class)
    override fun joinGame(request: Player, responseObserver: StreamObserver<Player>){
        val game = games[UUID.fromString(request.gameId)]
        if (game == null) {
            Util.err("No such game", responseObserver)
            return
        }
        if (game.verifier.role != Role.DEFAULT && game.guesser.role != Role.DEFAULT){
            Util.err("All players are already registered", responseObserver)
            return
        }
        val playerData = newPlayer(request, if(game.verifier.role == Role.DEFAULT) Role.VERIFIER else Role.GUESSER)
        updateGameData(game, playerData)
        val joinResponse = playerDataToPlayer(playerData)
        responseObserver.onNext(joinResponse)
        responseObserver.onCompleted()
    }

    private fun createGamesByNameResponse(filteredGameData: Collection<GameData>, name:String) =
        GamesByName.newBuilder()
            .setName(name)
            .addAllGames(filteredGameData.map { gameDataToGameDescription(it) })
            .build()

    override fun getGamesByName(request: GameDescription, responseObserver: StreamObserver<GamesByName>) {
        val filteredGames = games.filter { it.value.gameName == request.gameName }.values
        responseObserver.onNext(createGamesByNameResponse(filteredGames, request.gameName))
        responseObserver.onCompleted()
    }

}