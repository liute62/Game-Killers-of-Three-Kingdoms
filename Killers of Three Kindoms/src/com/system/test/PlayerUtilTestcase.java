package com.system.test;

import com.card.equipment.RedHareCard;
import com.card.equipment.ShadowRunnerCard;
import com.card.interfaces.MinusMountCard;
import com.card.interfaces.PlusMountCard;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.HeroName;
import com.system.enums.Kingdoms;
import com.system.enums.RoleType;
import com.system.utils.PlayerUtil;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerUtilTestcase {

    private PlayerUtil playerUtil;
    
    @Before
    public void setUp() {
        playerUtil = PlayerUtil.getInstance();
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
        MinusMountCard redHare = new RedHareCard();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        player2.setMinusMount(redHare);
        assertEquals(playerUtil.getDistance(player1, player2), 2);
        assertEquals(playerUtil.getDistance(player2, player1), 1);
    }

    @Test
    public void TestPlayerHasNoneWhileTargetHasPlus() {
        PlusMountCard shadowRunner = new ShadowRunnerCard();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        player2.setPlusMount(shadowRunner);
        assertEquals(playerUtil.getDistance(player1, player2), 3);
        assertEquals(playerUtil.getDistance(player2, player1), 2);
    }

    @Test
    public void TestPlayerHasPlusWhileTargetHasNone() {
        PlusMountCard shadowRunner = new ShadowRunnerCard();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        player1.setPlusMount(shadowRunner);
        assertEquals(playerUtil.getDistance(player1, player2), 2);
        assertEquals(playerUtil.getDistance(player2, player1), 3);
    }

    @Test
    public void TestPlayerHasPlusWhileTargetHasMinus() {
        PlusMountCard shadowRunner = new ShadowRunnerCard();
        MinusMountCard redHare = new RedHareCard();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        player1.setPlusMount(shadowRunner);
        player2.setMinusMount(redHare);
        assertEquals(playerUtil.getDistance(player1, player2), 2);
        assertEquals(playerUtil.getDistance(player2, player1), 2);
    }

    @Test
    public void TestPlayerHasMinusWhileTargetHasMinus() {
        MinusMountCard blueHare = new MinusMountCard() {
            @Override
            public int getAffectedRange() {
                return 2;
            }
        };
        MinusMountCard redHare = new RedHareCard();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(1);
        player2.setPosition(3);
        player1.setMinusMount(blueHare);
        player2.setMinusMount(redHare);
        assertEquals(playerUtil.getDistance(player1, player2), 0);
        assertEquals(playerUtil.getDistance(player2, player1), 1);
    }

    @Test
    public void TestPlayerHasMinusWhileTargetHasPlus() {
        PlusMountCard shadowRunner = new ShadowRunnerCard();
        MinusMountCard redHare = new RedHareCard();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPosition(2);
        player2.setPosition(5);
        player1.setMinusMount(redHare);
        player2.setPlusMount(shadowRunner);
        assertEquals(playerUtil.getDistance(player1, player2), 2);
        assertEquals(playerUtil.getDistance(player2, player1), 2);
    }

    @Test
    public void testInitInfoHelperZhaoYun() {
        PlayerUtil util = new PlayerUtil();
        APlayer player1 = new Player(false,0);
        util.initInfoHelper(0, player1, HeroName.ZhaoYun, false, RoleType.Minister);
        assertEquals(4, player1.getCurrentHP());
        assertEquals(4, player1.getMaxHP());
        assertEquals(Kingdoms.SHU, player1.getKingdom());
        assertEquals(1, player1.getAttackAbility());
        assertEquals(1, player1.getAttackRange());
    }

    @Test
    public void testInitInfoHelperZhenJi() {
        PlayerUtil util = new PlayerUtil();
        APlayer player1 = new Player(false,0);
        util.initInfoHelper(0, player1, HeroName.ZhenJi, false, RoleType.Minister);
        assertEquals(3, player1.getCurrentHP());
        assertEquals(3, player1.getMaxHP());
        assertEquals(Kingdoms.WEI, player1.getKingdom());
        assertEquals(1, player1.getAttackAbility());
        assertEquals(1, player1.getAttackRange());
    }

    @Test
    public void testInitInfo() {
        PlayerUtil util = new PlayerUtil();
        List<APlayer> data = new ArrayList<APlayer>();
        APlayer player1 = new Player(false,0);
        APlayer player2 = new Player(true,1);
        APlayer player3 = new Player(true,2);
        APlayer player4 = new Player(true,3);
        APlayer player5 = new Player(true,4);
        data.add(player1);
        data.add(player2);
        data.add(player3);
        data.add(player4);
        data.add(player5);
        util.initInfo(data);
        assertEquals(5, data.size());
        // TODO: add some verifications
    }
}
