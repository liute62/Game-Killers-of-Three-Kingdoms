package com.ai.test;

import org.junit.Assert;
import org.junit.Test;

import com.ai.service.AIAction;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class AIActionTestCase {

	AIAction aiAction;
	
	APlayer player;
	
	private void initial(){
		player = new Player();
		aiAction = new AIAction(player);
	}
	
	@Test
	public void testForOneCardForDrawCardStage(){
		initial();
		
	}
}
