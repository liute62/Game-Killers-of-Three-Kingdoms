package com.ai.test;


import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.Test;

import com.ai.service.AIAction;
import com.card.base.DodgeCard;
import com.card.base.PeachCard;
import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.GameStage;
import com.system.utils.DebugUtil;

public class AIActionTestCase {

	AIAction aiAction;
	
	APlayer player;
	
	private void initial(){
		player = new Player();
		aiAction = new AIAction(player);
	}
	
	private List<ACard> getHandsList(int num){
		List<ACard> cards = new ArrayList<ACard>();
		for (int i = 0; i < num; i++) {
			ACard card = null;
			cards.add(card);	
		}
		return cards;
	}
	
	private List<ACard> getHandsList(int strikeNum,int dodgeNum,int peachNum){
		List<ACard> cards = new ArrayList<ACard>();
		for (int i = 0; i < strikeNum; i++) {
			ACard card = new StrikeCard();
			cards.add(card);
		}for (int i = 0; i < dodgeNum; i++) {
			ACard card = new DodgeCard();
			cards.add(card);
		}for (int i = 0; i < peachNum; i++) {
			ACard card = new PeachCard();
			cards.add(card);
		}
		return cards;
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
	
	private APlayer result_test_4_5_6(int handNum, int dropNum){
		APlayer result = new Player();
		List<ACard> cards = getHandsList(handNum);
		List<ACard> tmp = new ArrayList<ACard>();
		for (int i = 0; i < dropNum; i++) {
				tmp.add(cards.get(i));
		}
		cards.removeAll(tmp);
		result.setHands(cards);
		return result;
	}
	
	private ACard result_test_7_8(int strikeNum,int dodgeNum,int peachNum,int index){
		APlayer result = new Player();
		result.gameStage = GameStage.castCard;
		List<ACard> tmp = getHandsList(strikeNum,dodgeNum,peachNum);
		result.setHands(tmp);
		List<ACard> cards = result.getAvailableCards(tmp);
		if (index == 1) {
			lastIndex = cards.size() - 1;
			return cards.get(lastIndex);
		}
		return cards.get(0);
	}
	
	private APlayer result_9(){
		List<APlayer> players = new ArrayList<APlayer>();
		for (int i = 1; i < 5; i++) {
			APlayer player = new Player();
			player.setPosition(i);
			players.add(player);
		}
		return players.get(0);
	}
	
//	@Test
//	public void test1_OneCardForDrawCardStage(){
//		initial();
//		aiAction.getPlayer().setDrawCardNum(1);
//		aiAction.drawCard();
//		Assert.assertEquals(1,aiAction.getPlayer().getHands().size());
//	}
	
	@Test 
	public void test2_TwoCardForDrawCardStage(){
		initial();
		aiAction.drawCard();
		Assert.assertEquals(2,aiAction.getPlayer().getHands().size());
	}
	
//	@Test
//	public void test3_ErrorNumCardForDrawCardStage(){
//		initial();
//		aiAction.getPlayer().setDrawCardNum(-1);
//		aiAction.drawCard();
//		Assert.assertEquals(result_test_1_2_3(-1).getHands(),aiAction.getPlayer().getHands());
//	}
	
//	@Test
//	public void test4_OneCardForDiscardStage(){
//		initial();
//		aiAction.getPlayer().setDiscardNum(1);
//		aiAction.getPlayer().setHands(getHandsList(1));
//		aiAction.dropCard();
//		Assert.assertEquals(result_test_4_5_6(1,1).getHands().size(),aiAction.getPlayer().getHands().size());
//	}
	
//	@Test
//	public void test5_TwoCardForDiscardStage(){
//		initial();
//		aiAction.getPlayer().setDiscardNum(2);
//		aiAction.getPlayer().setHands(getHandsList(2));
//		aiAction.dropCard();
//		Assert.assertEquals(result_test_4_5_6(2,2).getHands().size(),aiAction.getPlayer().getHands().size());
//	}
	
	@Test
	public void test6_ErrorNumForDiscardStage(){
		initial();
		aiAction.getPlayer().setDiscardNum(-1);
		aiAction.getPlayer().setHands(getHandsList(2));
		aiAction.dropCard();
		Assert.assertEquals(result_test_4_5_6(2,-1).getHands().size(),aiAction.getPlayer().getHands().size());
	}
	
//	@Test
//	public void test7_ChooseIndex0CardForCastcardStage(){
//		initial();
//		int num = 2;
//		aiAction.setCastCardIndex(0);
//		aiAction.getPlayer().setHands(getHandsList(num, num, num));
//		aiAction.castCard();
//		Assert.assertEquals(result_test_7_8(num,num,num,0).getName(),aiAction.getPlayer().getBeingUsedCard().getName());
//	}
	
	int lastIndex;
//	@Test
//	public void test8_ChooseIndexLastCardForCastcardStage(){
//		initial();
//		int num = 3;
//	    aiAction.getPlayer().setHands(getHandsList(num, num, num));
//	    String name = result_test_7_8(num,num,num,1).getName();
//		aiAction.setCastCardIndex(lastIndex);
//		aiAction.castCard();
//		Assert.assertEquals(name,aiAction.getPlayer().getBeingUsedCard().getName());
//	}
	
	//@Test
//	public void test9_GetAAvailableTargetForPos0Range1(){
//		initial();
//		int num = 3;
//		aiAction.getPlayer().setHands(getHandsList(num,num,num));
//		aiAction.getPlayer().setAttackRange(1);
//		aiAction.getPlayer().setPosition(0);
//		aiAction.castCard();
//		Assert.assertEquals(result_9().getPosition(),aiAction.getTarget().getPosition());
//	}
	
//	@Test
//	public void test10_randomlySetATarget(){
//		initial();
//		int num = 3;
//		aiAction.getPlayer().setHands(getHandsList(num,num,num));
//		aiAction.getPlayer().setAttackRange(1);
//		aiAction.getPlayer().setPosition(0);
//		aiAction.castCard();
//		Assert.assertNotNull(aiAction.getTarget());
//	}
}