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
	List<ACard> generateTestCards(){
		return new ArrayList<ACard>();
	}
	
	List<ACard> generateAvailableCards(){
		return new ArrayList<ACard>();
	}
	
	Player generateTestPlayer(){
		Player player = new Player();
		return player;
	}
	
	@Test
	public void testForZero(){
		Assert.assertEquals(generateAvailableCards(),generateTestPlayer().getAvailableCards(generateTestCards()));
	}
}
