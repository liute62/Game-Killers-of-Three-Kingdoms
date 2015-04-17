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
	
	private List<ACard> hands(Integer...integers) {
		List<ACard> list = new ArrayList<ACard>();
		for(int i = 0; i < integers.length; i ++)
		{
			StrikeCard strike = new StrikeCard();
			list.add(strike);
			list.get(i).setId(integers[i]);
		}
		return list;
	}
	
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
	public void testGain1HP() 
	{
		player.setCurrentHP(2);
		player.gainHP(1);
		assertEquals(3, player.getCurrentHP());
	}
	
	@Test
	public void testGain2HP() 
	{
		player.setCurrentHP(2);
		player.gainHP(2);
		assertEquals(4, player.getCurrentHP());
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
	
//	@Test
//	public void TestDropCards()
//	{
//		List<ACard> list = new ArrayList<ACard>();
//		player.setHands(list);
//		for(int i = 0; i < 5; i ++)
//		{
//			StrikeCard strike = new StrikeCard();
//			player.getHands().add(strike);
//			player.getHands().get(i).setId(i);
//		}
//		ArrayList<Integer> idList = new ArrayList<Integer>();
//		idList.add(1);
//		idList.add(3);
//		player.dropCards(idList);
//		assertEquals(hands(0,2,4), player.getHands());
//	}

}
