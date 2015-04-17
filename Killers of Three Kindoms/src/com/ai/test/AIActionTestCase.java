package com.ai.test;


import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.Test;

import com.ai.service.AIAction;
import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class AIActionTestCase {

	AIAction aiAction;
	
	APlayer player;
	
	private void initial(){
		player = new Player();
		aiAction = new AIAction(player);
	}
	
	private APlayer result_test_1_2_3(int num){
		APlayer result = new Player();
		List<ACard> cards = new ArrayList<ACard>();
		for (int i = 0; i < num; i++) {
			ACard card = null;
			cards.add(card);	
		}
		result.setHands(cards);
		return result;
	}
	
	private List<ACard> getHandsList(){
		List<ACard> cards = new ArrayList<>();
		ACard card = null;
		cards.add(card);
		return cards;
	}
	
	private APlayer result_4(){
		APlayer result = new Player();
		List<ACard> cards = getHandsList();
		cards.remove(0);
		result.setHands(cards);
		return result;
	}
	
	@Test
	public void test1_OneCardForDrawCardStage(){
		initial();
		aiAction.getPlayer().setDrawCardNum(1);
		aiAction.drawCard();
		Assert.assertEquals(result_test_1_2_3(1).getHands(),aiAction.getPlayer().getHands());
	}
	
	@Test 
	public void test2_TwoCardForDrawCardStage(){
		initial();
		aiAction.drawCard();
		Assert.assertEquals(result_test_1_2_3(2).getHands(),aiAction.getPlayer().getHands());
	}
	
	@Test
	public void test3_ErrorNumCardForDrawCardStage(){
		initial();
		aiAction.getPlayer().setDrawCardNum(-1);
		aiAction.drawCard();
		Assert.assertEquals(result_test_1_2_3(-1).getHands(),aiAction.getPlayer().getHands());
	}
	
	@Test
	public void test4_OneCardForDiscardStage(){
		initial();
		aiAction.getPlayer().setHands(getHandsList());
		aiAction.dropCard();
		Assert.assertEquals(result_4().getHands().size(),aiAction.getPlayer().getHands().size());
	}
}
