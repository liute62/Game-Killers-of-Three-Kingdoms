package com.logic.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.logic.player.Player;

public class LogicMainTestCase {
	Player player = new Player();
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test public void testLose1HP()
	{
		player.setCurrentHP(4);
		assertEquals(3, player.getCurrentHP());
	}
}
