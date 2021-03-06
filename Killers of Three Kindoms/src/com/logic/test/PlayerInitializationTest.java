package com.logic.test;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.hero.skills.active.ZhaoYun_Courage;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.HeroName;
import com.system.enums.RoleType;
import com.system.utils.IDatabase;


public class PlayerInitializationTest {
	IDatabase mockDB;
	@Before
	public void initialize() {
		this.mockDB = EasyMock.createMock(IDatabase.class);
	}
	
//	@Test
//	public void testInitializeMaxHP() {
//		String heroName = "Zhangliao";
//		int roleType = 2; // RoleType 2 means Minister
//		EasyMock.expect(mockDB.getMaxHP(heroName)).andReturn(4);
//		EasyMock.replay(mockDB);
//		
//		APlayer p1 = new Player(heroName, roleType);
//		p1.Database = mockDB;
//		
//		p1.initializePlayerInfo();
//		assertEquals(4, p1.getMaxHP());
//		EasyMock.verify(mockDB);
//	}
//	
//	@Test
//	// If the role of a player is monarch, He can get 1 more max HP
//	public void testInitializeMaxHPIfRoleIsMonarch() {
//		String heroName = "Caocao";
//		int roleType = 1; //RoleType 1 means Monarch
//		int originalMaxHP = 4;
//		EasyMock.expect(mockDB.getMaxHP(heroName)).andReturn(originalMaxHP);
//		EasyMock.replay(mockDB);
//		
//		APlayer p1 = new Player(heroName, roleType);
//		p1.Database = mockDB;
//		
//		p1.initializePlayerInfo();
//		int actualMaxHP = originalMaxHP + 1;
//		assertEquals(actualMaxHP, p1.getMaxHP());
//		EasyMock.verify(mockDB);
//	}
	@Test
	public void testHeroNameSet() {
		HeroName name = HeroName.ZhangLiao;
		RoleType type = RoleType.Minister;
		APlayer p1 = new Player(name, type);
		assertEquals(name,p1.getName());
	}
	
	@Test
	public void testRoleTypeSet() {
		HeroName name = HeroName.ZhangLiao;
		RoleType type = RoleType.Minister;
		APlayer p1 = new Player(name, type);
		assertEquals(type, p1.getRoleType());
	}
	
	@Test
	public void testDefaultAttackRangeSet() {
		HeroName name = HeroName.ZhangLiao;
		RoleType type = RoleType.Minister;
		APlayer p1 = new Player(name, type);
		assertEquals(1, p1.getAttackRange());
	}
	
	@Test
	public void testInitializeMaxHP() {
		HeroName name = HeroName.ZhangLiao;
		RoleType roleType = RoleType.Minister;
		EasyMock.expect(mockDB.getMaxHP(name)).andReturn(4);
		EasyMock.replay(mockDB);
		
		APlayer p1 = new Player(name, roleType);
		p1.Database = mockDB;
		
		p1.initializePlayerInfo();
		assertEquals(4, p1.getMaxHP());
		EasyMock.verify(mockDB);
	}
	
	@Test
	// If the role of a player is monarch, He can get 1 more max HP
	public void testInitializeMaxHPIfRoleIsMonarch() {
		HeroName heroName = HeroName.CaoCao;
		RoleType roleType = RoleType.Monarch;
		int originalMaxHP = 4;
		EasyMock.expect(mockDB.getMaxHP(heroName)).andReturn(originalMaxHP);
		EasyMock.replay(mockDB);
		
		APlayer p1 = new Player(heroName, roleType);
		p1.Database = mockDB;
		
		p1.initializePlayerInfo();
		int actualMaxHP = originalMaxHP + 1;
		assertEquals(actualMaxHP, p1.getMaxHP());
		EasyMock.verify(mockDB);
	}
	
	
	
}
