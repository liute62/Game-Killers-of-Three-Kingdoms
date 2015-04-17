package com.card.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.card.equipment.EightDiagramFormationCard;
import com.card.equipment.ShadowRunner;
import com.card.interfaces.AmorCard;
import com.card.interfaces.MountCard;
import com.logic.player.APlayer;
import com.logic.player.Player;


public class EquipmentCardTestCase {
	APlayer p1;
	List<APlayer> targetPlayers;
	
	@Before
	public void playerInitialize()
	{
		this.p1  = new Player();
		this.targetPlayers = new ArrayList<APlayer>();
	}
	
	
	@Test
	public void testAmorCardCanCorrectlyUse()
	{
		targetPlayers.add(p1);
		AmorCard target = new EightDiagramFormationCard();
		target.use(p1, targetPlayers);
		Assert.assertEquals(target, p1.getAmor());
		Assert.assertSame(target, p1.getAmor());
		
	}
	
	@Test
	public void testMountCardCanCorrectlyUse()
	{
		targetPlayers.add(p1);
		MountCard target = new ShadowRunner();
		target.use(p1, targetPlayers);
		Assert.assertEquals(target, p1.getMount());
		Assert.assertEquals(target, p1.getMount());
	}
}