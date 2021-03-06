package com.logic.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.card.base.DodgeCard;
import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.constants.CardConst;
import com.system.enums.GameStage;

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
	
	List<ACard> generateTestDodgeCards(int num){
		List<ACard> list = new ArrayList<ACard>();
		for (int i = 0; i < num; i++) {
			ACard card = new DodgeCard();
			card.setType(CardConst.CardType_Dodge);
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
	
	List<ACard> generateAvailableCards(int num,GameStage state){
		List<ACard> list = new ArrayList<ACard>();
		if(state == GameStage.begin){
			return list;
		}if(state == GameStage.check){
			return list;
		}if(state == GameStage.drawCard){
			return list;
		}if(state == GameStage.castCard){
		}
		for (int i = 0; i < num; i++) {
			ACard card = null;
			list.add(card);
		}
		return list;
	}
	
	List<ACard> generateAvailableCards_castCard_Dodge(int numOfAll,int numOfDodge){
		List<ACard> list = new ArrayList<ACard>();
		for (int i = 0; i < numOfAll - numOfDodge; i++) {
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
		player.gameStage = GameStage.begin;
		Assert.assertEquals(generateAvailableCards(10,GameStage.begin),player.getAvailableCards(generateTestCards(10)));
	}
	
	@Test
	public void testForCheckState(){
		Player player = generateTestPlayer();
		player.gameStage = GameStage.check;
		Assert.assertEquals(generateAvailableCards(10,GameStage.check),player.getAvailableCards(generateTestCards(10)));
	}
	
	@Test
	public void testForDrawCardState(){
		Player player = generateTestPlayer();
		player.gameStage = GameStage.drawCard;
		Assert.assertEquals(generateAvailableCards(10,GameStage.drawCard),player.getAvailableCards(generateTestCards(10)));
	}
	
	@Test
	public void testForCastCardState(){
		Player player = generateTestPlayer();
		player.gameStage = GameStage.castCard;
		Assert.assertEquals(generateAvailableCards(10,GameStage.castCard),player.getAvailableCards(generateTestCards(10)));
	}
	
	@Test
	public void testForCastCardStateAndDodgeCard(){
		Player player = generateTestPlayer();
		player.gameStage = GameStage.castCard;
		Assert.assertEquals(generateAvailableCards_castCard_Dodge(10,10),player.getAvailableCards(generateTestDodgeCards(10)));
	}
	
	@Test
	public void testForDropCardState(){
		Player player = generateTestPlayer();
		player.gameStage = GameStage.discard;
		Assert.assertEquals(generateAvailableCards(10,GameStage.discard),player.getAvailableCards(generateTestCards(10)));
	}
	
	@Test
	public void testForEndState(){
		Player player = generateTestPlayer();
		player.gameStage = GameStage.end;
		Assert.assertEquals(generateAvailableCards(10,GameStage.end),player.getAvailableCards(generateTestCards(10)));
	}
}
