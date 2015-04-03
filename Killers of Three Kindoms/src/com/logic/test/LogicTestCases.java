package com.logic.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class LogicTestCases {


	/**Test for class APlayer getAvailableCards()**/
	List<ACard> generateTestCards(int num){
		List<ACard> list = new ArrayList<ACard>();
		if(num == 1){
			ACard card = null;
			list.add(card);
		}
		return list;
	}
	
	List<ACard> generateAvailableCards(int num){
		List<ACard> list = new ArrayList<ACard>();
		if(num == 1){
			ACard card = null;
			list.add(card);
		}
		return list;
	}
	
	Player generateTestPlayer(){
		Player player = new Player();
		return player;
	}
	
	@Test
	public void testForZero(){
		Assert.assertEquals(generateAvailableCards(0),generateTestPlayer().getAvailableCards(generateTestCards(0)));
	}
	
	@Test
	public void testForOne(){
		Assert.assertEquals(generateAvailableCards(1),generateTestPlayer().getAvailableCards(generateTestCards(1)));
	}
}
