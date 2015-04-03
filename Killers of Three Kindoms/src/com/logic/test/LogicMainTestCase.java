package com.logic.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.logic.player.Player;

public class LogicMainTestCase {
	Player player = new Player();
	
	
	@Test 
	public void testLose1HP()
	{
		player.setCurrentHP(4);
		player.loseHP(1);
		assertEquals(3, player.getCurrentHP());
	}
	
	@Test 
	public void testLose2HP()
	{
		player.setCurrentHP(4);
		player.loseHP(2);
		assertEquals(2, player.getCurrentHP());
	}
	
	@Test
	public void TestIfDropCardsWhenHPLessThanHands()
	{
		ACard aCard = null;
		List<ACard> list = new ArrayList<ACard>();
		player.setHands(list);
		player.setCurrentHP(2);
		for(int i =0; i < 5; i ++)
		{
			player.getHands().add(aCard);
		}
		assertEquals(true, player.ifDropCards());
	}
	
	@Test
	public void TestIfDropCardsWhenHPMoreThanHands()
	{
		ACard aCard = null;
		List<ACard> list = new ArrayList<ACard>();
		player.setHands(list);
		player.setCurrentHP(4);
		for(int i =0; i < 3; i ++)
		{
			player.getHands().add(aCard);
		}
		assertEquals(false, player.ifDropCards());
	}
}
