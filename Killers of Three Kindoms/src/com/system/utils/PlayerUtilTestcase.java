package com.system.utils;

import com.card.equipment.RedHare;
import com.card.interfaces.IMountCard;
import com.logic.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerUtilTestcase {

    private PlayerUtil playerUtil;
    
    @Before
    public void setUp() {
        playerUtil = new PlayerUtil();
    }
    
    @Test
    public void testGetDistanceWorksForDistanceOne() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(2);
        assertEquals(playerUtil.getDistance(player1, player2), 1);
    }

    @Test
    public void testGetDistanceWorksForDistanceTwo() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        assertEquals(playerUtil.getDistance(player1, player2), 2);
    }

    @Test
    public void testGetDistanceWorksForAnotherDistanceOne() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(2);
        player2.setPosition(3);
        assertEquals(playerUtil.getDistance(player1, player2), 1);
    }

    @Test
    public void testGetDistanceWorksForAnotherDistanceTwo() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(2);
        player2.setPosition(4);
        assertEquals(playerUtil.getDistance(player1, player2), 2);
    }

    @Test
    public void testGetDistanceWorksForDistanceOneReverse() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(2);
        assertEquals(playerUtil.getDistance(player2, player1), 1);
    }

    @Test
    public void testGetDistanceWorksForDistanceTwoReverse() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        assertEquals(playerUtil.getDistance(player2, player1), 2);
    }

    @Test
    public void testGetDistanceWorksForWrappedDistanceOne() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(5);
        assertEquals(playerUtil.getDistance(player2, player1), 1);
    }

    @Test
    public void testGetDistanceWorksForWrappedDistanceTwo() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(2);
        player2.setPosition(5);
        assertEquals(playerUtil.getDistance(player2, player1), 2);
    }

    @Test(expected = RuntimeException.class)
    public void testGetDistanceWorksDoesThrowExceptionLowerBound() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(0);
        player2.setPosition(2);
        playerUtil.getDistance(player1, player2);
    }

    @Test(expected = RuntimeException.class)
    public void testGetDistanceWorksDoesThrowExceptionUpperBound() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(2);
        player2.setPosition(6);
        playerUtil.getDistance(player1, player2);
    }

    @Test
    public void TestPlayerHasNoneWhileTargetHasMinus() {
        IMountCard redHare = new RedHare();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        player2.setMinusMount(redHare);
        assertEquals(playerUtil.getDistance(player1, player2), 2);
        assertEquals(playerUtil.getDistance(player2, player1), 1);
    }

}
