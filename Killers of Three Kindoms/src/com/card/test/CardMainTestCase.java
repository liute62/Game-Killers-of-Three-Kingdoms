package com.card.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.card.base.StrikeCard;
import com.card.equipment.*;
import com.card.interfaces.MinusMountCard;
import com.card.interfaces.PlusMountCard;
import com.card.interfaces.WeaponCard;
import com.system.constants.SuitConst;
import org.junit.Test;

import com.card.base.PeachCard;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class CardMainTestCase {

    private List<Integer> list(Integer...integers) {
        return Arrays.asList(integers);
    }

    @Test
    public void testForEightDiagramFormationCard() {
        EightDiagramFormationCard card = new EightDiagramFormationCard();
        assertEquals(true,card.check(SuitConst.SuitType_Hearts));
        assertEquals(true,card.check(SuitConst.SuitType_Diamonds));
        assertEquals(false,card.check(SuitConst.SuitType_Clubs));
        assertEquals(false,card.check(SuitConst.SuitType_Spades));
    }

    @Test
    public void testUsingPeachCardForOnePlayer() {
        PeachCard peach = new PeachCard();
        APlayer p1 = new Player();
        APlayer p2 = new Player();
        p2.setCurrentHP(1);
        p2.setMaxHP(5);
        List<APlayer> targetPlayers = new ArrayList<APlayer>();
        targetPlayers.add(p2);

        List<Integer> healthList = new ArrayList<Integer>();
        peach.use(p1, targetPlayers);
        for(APlayer targetPlayer: targetPlayers)
        {
            healthList.add(targetPlayer.getCurrentHP());
        }
        assertEquals(list(2), healthList);
    }

    @Test
    public void testUsingPeachCardForTwoPlayers() {
        PeachCard peach = new PeachCard();
        APlayer p1 = new Player();
        APlayer p2 = new Player();
        p1.setMaxHP(5);
        p2.setMaxHP(5);
        p1.setCurrentHP(2);
        p2.setCurrentHP(1);
        List<APlayer> targetPlayers = new ArrayList<APlayer>();

        targetPlayers.add(p1);
        targetPlayers.add(p2);

        List<Integer> healthList = new ArrayList<Integer>();
        peach.use(p1, targetPlayers);
        for(APlayer targetPlayer: targetPlayers)
        {
            healthList.add(targetPlayer.getCurrentHP());
        }
        assertEquals(list(3,2), healthList);
    }

    @Test
    public void testStrikeOnePlayerInRange() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(2);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(2);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        assertEquals(strike.checkTarget(player, playerList), true);
    }

    @Test
    public void testStrikeOnePlayerOutOfRange() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        assertEquals(strike.checkTarget(player, playerList), false);
    }

    @Test
    public void testStrikeTwoPlayersInRange() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        APlayer player2 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(2);
        player2.setCurrentHP(5);
        player2.setPosition(5);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        playerList.add(player2);
        assertEquals(strike.checkTarget(player, playerList), true);
    }

    @Test
    public void testStrikeTwoPlayersOutOfRange() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        APlayer player2 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
        player2.setCurrentHP(5);
        player2.setPosition(4);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        playerList.add(player2);
        assertEquals(strike.checkTarget(player, playerList), false);
    }

    @Test
    public void testStrikeOnePlayersInRangeAnotherOutOfRange() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        APlayer player2 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(2);
        player2.setCurrentHP(5);
        player2.setPosition(4);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        playerList.add(player2);
        assertEquals(strike.checkTarget(player, playerList), false);
    }

    @Test
    public void testStrikeOnePlayerDead() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(2);
        player.setPosition(1);
        player1.setCurrentHP(0);
        player1.setPosition(2);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        assertEquals(strike.checkTarget(player, playerList), false);
    }

    @Test
    public void testStrikeTwoPlayersDead() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        APlayer player2 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(2);
        player.setPosition(1);
        player1.setCurrentHP(0);
        player1.setPosition(2);
        player2.setCurrentHP(0);
        player2.setPosition(4);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        playerList.add(player2);
        assertEquals(strike.checkTarget(player, playerList), false);
    }

    @Test
    public void testStrikeOnePlayerDeadAnotherAlive() {
        StrikeCard strike = new StrikeCard();
        APlayer player = new Player();
        APlayer player1 = new Player();
        APlayer player2 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(2);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(2);
        player2.setCurrentHP(-1);
        player2.setPosition(4);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);
        playerList.add(player2);
        assertEquals(strike.checkTarget(player, playerList), false);
    }

//    @Test
//    public void TestPlayerWithQilinAttackTargetWithPlusMount() {
//        WeaponCard qilinBow = new QilinBowCard();
//        StrikeCard strike = new StrikeCard();
//        PlusMountCard shadowRunner = new ShadowRunnerCard();
//
//        APlayer player = new Player();
//        APlayer player1 = new Player();
//        player.setCurrentHP(3);
//        player.setAttackRange(2);
//        player.setPosition(1);
//        player.setWeapon(qilinBow);
//        player1.setCurrentHP(2);
//        player1.setPosition(2);
//        player1.setPlusMount(shadowRunner);
//        List<APlayer> playerList = new ArrayList<>();
//        playerList.add(player1);
//
//        strike.use(player, playerList);
//        assertNull(player1.getPlusMount());
//    }

    @Test
    public void TestPlayerWithoutQilinAttackTargetWithPlusMount() {
        StrikeCard strike = new StrikeCard();
        PlusMountCard shadowRunner = new ShadowRunnerCard();

        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(3);
        player.setAttackRange(2);
        player.setPosition(1);
        player1.setCurrentHP(2);
        player1.setPosition(2);
        player1.setPlusMount(shadowRunner);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);

        strike.use(player, playerList);
        assertSame(player1.getPlusMount(), shadowRunner);
    }

//    @Test
//    public void TestPlayerWithQilinAttackTargetWithMinusMount() {
//        WeaponCard qilinBow = new QilinBowCard();
//        StrikeCard strike = new StrikeCard();
//        MinusMountCard redHare = new RedHareCard();
//
//        APlayer player = new Player();
//        APlayer player1 = new Player();
//        player.setCurrentHP(3);
//        player.setAttackRange(2);
//        player.setPosition(1);
//        player.setWeapon(qilinBow);
//        player1.setCurrentHP(2);
//        player1.setPosition(2);
//        player1.setMinusMount(redHare);
//        List<APlayer> playerList = new ArrayList<>();
//        playerList.add(player1);
//
//        strike.use(player, playerList);
//        assertNull(player1.getMinusMount());
//    }

    @Test
    public void TestPlayerWithoutQilinAttackTargetWithMinusMount() {
        WeaponCard blackPommel = new BlackPommelCard();
        StrikeCard strike = new StrikeCard();
        MinusMountCard redHare = new RedHareCard();

        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(3);
        player.setAttackRange(2);
        player.setPosition(1);
        player.setWeapon(blackPommel);
        player1.setCurrentHP(2);
        player1.setPosition(2);
        player1.setMinusMount(redHare);
        List<APlayer> playerList = new ArrayList<APlayer>();
        playerList.add(player1);

        strike.use(player, playerList);
        assertSame(player1.getMinusMount(), redHare);
    }

//    @Test
//    public void TestPlayerWithQilinAttackTargetWithBothMount() {
//        WeaponCard qilinBow = new QilinBowCard();
//        StrikeCard strike = new StrikeCard();
//        MinusMountCard redHare = new RedHareCard();
//        PlusMountCard shadowRunner = new ShadowRunnerCard();
//
//        APlayer player = new Player();
//        APlayer player1 = new Player();
//        player.setCurrentHP(3);
//        player.setAttackRange(2);
//        player.setPosition(1);
//        player.setWeapon(qilinBow);
//        player1.setCurrentHP(2);
//        player1.setPosition(2);
//        player1.setMinusMount(redHare);
//        player1.setPlusMount(shadowRunner);
//        List<APlayer> playerList = new ArrayList<>();
//        playerList.add(player1);
//
//        strike.use(player, playerList);
//        assertNull(player1.getMinusMount());
//        assertNull(player1.getPlusMount());
//    }
}
