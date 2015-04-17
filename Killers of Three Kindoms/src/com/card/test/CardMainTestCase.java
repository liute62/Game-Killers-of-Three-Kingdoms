package com.card.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.card.base.PeachCard;
import com.card.equipment.EightDiagramFormationCard;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class CardMainTestCase {
	
	private List<Integer> list(Integer...integers) {
		return Arrays.asList(integers);
	}

	@Test
	public void testForEightDiagramFormationCard() {
		EightDiagramFormationCard card = new EightDiagramFormationCard();
		assertEquals(true,card.check("Heart"));
		assertEquals(true,card.check("Diamond"));
		assertEquals(false,card.check("Club"));
		assertEquals(false,card.check("Spade"));
	}
	
	@Test
	public void testUsingPeachCardForOnePlayer() {
		PeachCard peach = new PeachCard();
		APlayer p1 = new Player();
		APlayer p2 = new Player();
		p2.setCurrentHP(1);
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

}
