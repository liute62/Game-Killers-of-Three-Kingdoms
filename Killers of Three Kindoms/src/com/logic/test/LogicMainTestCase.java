package com.logic.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.logic.player.Player;

public class LogicMainTestCase {
	Player player = new Player();
	
	
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
}
