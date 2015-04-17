package com.card.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.card.equipment.EightDiagramFormationCard;
import com.card.interfaces.AmorCard;
import com.logic.player.APlayer;
import com.logic.player.Player;


public class AmorCardTestCase {
	
	@Test
	public void testAmorCardCanCorrectlyUse()
	{
		APlayer p1  = new Player();
		List<APlayer> targetPlayers = new ArrayList<APlayer>();
		targetPlayers.add(p1);
		
		AmorCard target = new EightDiagramFormationCard();
		target.use(p1, targetPlayers);
		Assert.assertEquals(target, p1.getAmor());
		Assert.assertSame(target, p1.getAmor());
		
	}
}
