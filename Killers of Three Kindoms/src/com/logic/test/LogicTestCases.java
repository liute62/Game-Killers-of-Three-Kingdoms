package com.logic.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.GameState;

public class LogicTestCases {


	/**Test for class APlayer getAvailableCards()**/
	List<ACard> generateTestCards(int num){
		List<ACard> list = new ArrayList<ACard>();
		for (int i = 0; i < num; i++) {
			ACard card = null;
			list.add(card);
		}
		return list;
	}
	
	List<ACard> generateAvailableCards(int num){
		List<ACard> list = new ArrayList<ACard>();
		for (int i = 0; i < num; i++) {
			ACard card = null;
			list.add(card);
		}
		return list;
	}
	
	List<ACard> generateAvailableCards(int num,GameState state){
		List<ACard> list = new ArrayList<ACard>();
		if(state == GameState.begin){
			return list;
		}if(state == GameState.check){
			return list;
		}
		for (int i = 0; i < num; i++) {
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
	
	@Test
	public void testForTen(){
		Assert.assertEquals(generateAvailableCards(10),generateTestPlayer().getAvailableCards(generateTestCards(10)));
	}
	
	@Test
	public void testForBeginState(){
		Player player = generateTestPlayer();
		player.gameState = GameState.begin;
		Assert.assertEquals(generateAvailableCards(10,GameState.begin),player.getAvailableCards(generateTestCards(10)));
	}
	
	@Test
	public void testForCheckState(){
		Player player = generateTestPlayer();
		player.gameState = GameState.check;
		Assert.assertEquals(generateAvailableCards(10,GameState.check),player.getAvailableCards(generateTestCards(10)));
	}
}
