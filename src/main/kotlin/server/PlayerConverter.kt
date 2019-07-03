package server

import java.util.*

data class PlayerData(
    val name: String = "empty spot",
    val role: Role = Role.DEFAULT,
    val id: UUID = UUID(0L, 0L),
    val gameId: UUID = UUID(0L, 0L)
)

class PlayerConverter{

    companion object {
        @JvmStatic
        fun playerDataToPlayer(playerData: PlayerData) =
            Player.newBuilder()
                .setGameId(playerData.gameId.toString())
                .setPlayerName(playerData.name)
                .setPlayerId(playerData.id.toString())
                .setRole(playerData.role)
                .build()

        @JvmStatic
        fun newPlayer(player: Player, role: Role) =
            PlayerData(
                name = player.playerName,
                id = UUID.randomUUID(),
                role = role,
                gameId = UUID.fromString(player.gameId)
            )

        @JvmStatic
        fun playerToPlayerData(player: Player) =
            PlayerData(
                name = player.playerName,
                id = UUID.fromString(player.playerId),
                role = player.role,
                gameId = UUID.fromString(player.gameId)
            )
    }
}