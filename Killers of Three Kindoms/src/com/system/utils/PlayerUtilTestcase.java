package com.system.utils;

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
}
