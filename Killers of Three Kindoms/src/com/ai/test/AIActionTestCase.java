package com.ai.test;


import java.util.ArrayList;
import java.util.List;

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
	
	private APlayer result_test1(){
		APlayer result = new Player();
		ACard card = null;
		List<ACard> cards = new ArrayList<ACard>();
		cards.add(card);
		result.setHands(cards);
		return result;
	}
	
	@Test
	public void test1_OneCardForDrawCardStage(){
		initial();
		aiAction.drawCard();
		Assert.assertEquals(result_test1(),aiAction.getPlayer());
	}
	
}