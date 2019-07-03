package server

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.grpc.stub.StreamObserver
import java.util.*

class Util{

    companion object {
        @JvmStatic
        fun <T> err(description: String, responseObserver: StreamObserver<T>, code: Status = Status.UNAVAILABLE){
            responseObserver.onError(StatusRuntimeException(code.withDescription(description)))
        }

        @JvmStatic
        fun <R, T> authenticate(
            arg: R,
            player: Player,
            responseObserver: StreamObserver<T>,
            correctRole: Role,
            globalManager: GamesGlobalManager,
            onAuthenticated: (arg: R, responseObserver: StreamObserver<T>) -> Unit
        ){
            val uuid = UUID.fromString(player.gameId)
            val gameData = globalManager.gameById(uuid)
            if(gameData == null){
                Util.err("No game with uuid: $uuid", responseObserver)
                return
            }
            val userNotInGame =
                gameData.verifier.id != UUID.fromString(player.playerId) &&
                        gameData.guesser.id != UUID.fromString(player.playerId)
            if(userNotInGame){
                Util.err("You do not take part in the game with uuid: $uuid", responseObserver)
                return
            }
            if(player.role != correctRole){
                Util.err("You are not allowed to be in the role of $correctRole in this room", responseObserver)
                return
            }
            onAuthenticated(arg, responseObserver)
        }

        @JvmStatic
        fun newCombinationRequest(
            combinationArray: Array<Color>,
            player: Player
        ) =
            Combination.newBuilder()
                .setFirst(combinationArray[0])
                .setSecond(combinationArray[1])
                .setThird(combinationArray[2])
                .setFourth(combinationArray[3])
                .setPlayer(player)
                .build()
    }
}