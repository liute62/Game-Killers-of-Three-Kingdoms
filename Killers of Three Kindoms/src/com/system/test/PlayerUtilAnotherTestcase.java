package com.system.test;

import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.GameStage;
import com.system.enums.RoleType;
import com.system.utils.PlayerUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerUtilAnotherTestcase {

    @Test
    public void testGetWinningRolesReturnsMonarchAndMinister() {
        PlayerUtil playerUtil = new PlayerUtil();
        APlayer player1 = new Player();
        APlayer player2 = new Player();
        APlayer player3 = new Player();
        APlayer player4 = new Player();
        APlayer player5 = new Player();
        playerUtil.setPlayer(player1);
        playerUtil.setPlayers(Arrays.asList(player1, player2, player3, player4, player5));
        player1.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player3.setNextPlayer(player4);
        player4.setNextPlayer(player5);
        player5.setNextPlayer(player1);
        // Player1: Monarch, alive
        // Player2: Minister, alive
        // Player3: Rebel, dead
        // Player4: Rebel, dead
        // Player5: Traitor, dead
        player1.setRoleType(RoleType.Monarch);
        player1.setGameStage(GameStage.castCard);
        player2.setRoleType(RoleType.Minister);
        player2.setGameStage(GameStage.end);
        player3.setRoleType(RoleType.Rebel);
        player3.setGameStage(GameStage.gameOver);
        player4.setRoleType(RoleType.Rebel);
        player4.setGameStage(GameStage.gameOver);
        player5.setRoleType(RoleType.Trun_coat);
        player5.setGameStage(GameStage.gameOver);

        List<RoleType> results = playerUtil.getWinningRoles();
        assertEquals(2, results.size());
        assertEquals(true, results.contains(RoleType.Monarch));
        assertEquals(true, results.contains(RoleType.Minister));
    }

    @Test
    public void testGetWinningRolesReturnsTraitor() {
        PlayerUtil playerUtil = new PlayerUtil();
        APlayer player1 = new Player();
        APlayer player2 = new Player();
        APlayer player3 = new Player();
        APlayer player4 = new Player();
        APlayer player5 = new Player();
        playerUtil.setPlayer(player1);
        playerUtil.setPlayers(Arrays.asList(player1, player2, player3, player4, player5));
        player1.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player3.setNextPlayer(player4);
        player4.setNextPlayer(player5);
        player5.setNextPlayer(player1);
        // Player1: Traitor, alive
        // Player2: Rebel, dead
        // Player3: Monarch, dead
        // Player4: Minister, dead
        // Player5: Rebel, dead
        player1.setRoleType(RoleType.Trun_coat);
        player1.setGameStage(GameStage.castCard);
        player2.setRoleType(RoleType.Rebel);
        player2.setGameStage(GameStage.gameOver);
        player3.setRoleType(RoleType.Monarch);
        player3.setGameStage(GameStage.gameOver);
        player4.setRoleType(RoleType.Minister);
        player4.setGameStage(GameStage.gameOver);
        player5.setRoleType(RoleType.Rebel);
        player5.setGameStage(GameStage.gameOver);

        List<RoleType> results = playerUtil.getWinningRoles();
        assertEquals(1, results.size());
        assertEquals(true, results.contains(RoleType.Rebel));
    }
}
