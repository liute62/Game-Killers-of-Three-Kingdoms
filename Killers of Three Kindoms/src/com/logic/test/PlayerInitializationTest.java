package com.logic.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.utils.IDatabase;


public class PlayerInitializationTest {
	IDatabase mockDB;
	@Before
	public void initialize() {
		this.mockDB = EasyMock.createMock(IDatabase.class);
	}
	
	@Test
	public void testInitializeMaxHP() {
		String heroName = "Zhangliao";
		int roleType = 10;
		EasyMock.expect(mockDB.getMaxHP(heroName)).andReturn(4);
		EasyMock.replay(mockDB);
		
		APlayer p1 = new Player(heroName, roleType);
		p1.Database = mockDB;
		
		p1.initializePlayerInfo();
		assertEquals(4, p1.getMaxHP());
		EasyMock.verify(mockDB);
		
		
	}
	
}
