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
	
	private List<ACard> getHandsList(int num){
		List<ACard> cards = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			ACard card = null;
			cards.add(card);	
		}
		return cards;
	}
	
	private APlayer result_test_4_5_6(int handNum, int dropNum){
		APlayer result = new Player();
		List<ACard> cards = getHandsList(handNum);
		List<ACard> tmp = new ArrayList<>();
		for (int i = 0; i < dropNum; i++) {
				tmp.add(cards.get(i));
		}
		cards.removeAll(tmp);
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
		aiAction.getPlayer().setDiscardNum(1);
		aiAction.getPlayer().setHands(getHandsList(1));
		aiAction.dropCard();
		Assert.assertEquals(result_test_4_5_6(1,1).getHands().size(),aiAction.getPlayer().getHands().size());
	}
	
	@Test
	public void test5_TwoCardForDiscardStage(){
		initial();
		aiAction.getPlayer().setDiscardNum(2);
		aiAction.getPlayer().setHands(getHandsList(2));
		aiAction.dropCard();
		Assert.assertEquals(result_test_4_5_6(2,2).getHands().size(),aiAction.getPlayer().getHands().size());
	}
	
	@Test
	public void test6_ErrorNumForDiscardStage(){
		initial();
		aiAction.getPlayer().setDiscardNum(-1);
		aiAction.getPlayer().setHands(getHandsList(2));
		aiAction.dropCard();
		Assert.assertEquals(result_test_4_5_6(2,-1).getHands().size(),aiAction.getPlayer().getHands().size());
	}
	
	public void test7_ChooseACardForCastcardStage(){
		
	}
}