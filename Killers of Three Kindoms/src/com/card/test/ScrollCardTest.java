package com.card.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.card.scroll.PeachGarden;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class ScrollCardTest {
	Player p1,p2,p3,p4,p5;
	List<APlayer> targetPlayers;
	
	private List<Integer> list(Integer...integers) {
        return Arrays.asList(integers);
    }

	@Before
	public void playerInitialize()
	{
		this.p1 = new Player();
		this.p2 = new Player();
		this.p3 = new Player();
		this.p4 = new Player();
		this.p5 = new Player();
		this.targetPlayers = new ArrayList<APlayer>();
	}
	@Test
	public void testPeachGardenRecover1HealthForEachPlayer()
	{	
		p1.setCurrentHP(2);
		p2.setCurrentHP(3);
		p3.setCurrentHP(4);
		
		targetPlayers.add(p1);
		targetPlayers.add(p2);
		targetPlayers.add(p3);
		
		PeachGarden target = new PeachGarden();
		
		target.use(p1, targetPlayers);
		Assert.assertEquals(3,targetPlayers.get(0).getCurrentHP());
		Assert.assertEquals(4, targetPlayers.get(1).getCurrentHP());
		Assert.assertEquals(5, targetPlayers.get(2).getCurrentHP());
	}
	
	@Test
	public void testPeachGardenWorksCorrectlyWhenPlayerHPIsFull()
	{
		p1.setCurrentHP(3);
		p1.setMaxHP(3);
		p2.setCurrentHP(3);
		p2.setMaxHP(3);
		p3.setCurrentHP(4);
		p3.setMaxHP(4);
		
		targetPlayers.add(p1);
		targetPlayers.add(p2);
		targetPlayers.add(p3);
		
		PeachGarden target = new PeachGarden();
		
		target.use(p1, targetPlayers);
		Assert.assertEquals(3,targetPlayers.get(0).getCurrentHP());
		Assert.assertEquals(3, targetPlayers.get(1).getCurrentHP());
		Assert.assertEquals(4, targetPlayers.get(2).getCurrentHP());
	}
	@Test
	public void testPeachGardenRecoverHPInCorrectOrder()
	{
		p1.setCurrentHP(2);
		p2.setCurrentHP(3);
		p3.setCurrentHP(4);
		
		p1.setPosition(3);
		p2.setPosition(1);
		p3.setPosition(5);
		
		//create a array to represent correct order of recovering health.
		List<APlayer> order = new ArrayList<APlayer>();
		order.add(p1);
		order.add(p3);
		order.add(p2);
		
		targetPlayers.add(p1);
		targetPlayers.add(p2);
		targetPlayers.add(p3);
		
		PeachGarden target = new PeachGarden();
		target.use(p1, targetPlayers);
		
		Assert.assertEquals(order, target.getOrderOfRecovering());
	}
}
