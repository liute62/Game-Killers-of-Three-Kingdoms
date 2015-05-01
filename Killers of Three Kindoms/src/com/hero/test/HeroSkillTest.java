package com.hero.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.card.base.DodgeCard;
import com.card.base.PeachCard;
import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.hero.skills.trigger.GuoJia_Talented;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.enums.GameState;
import com.system.enums.HeroName;

public class HeroSkillTest {
	
	private List<ACard> hands(ACard...cards) {
        return Arrays.asList(cards);
    }
	
	@Test
	public void testTalented()
	{
		APlayer p1 = new Player();
		GuoJia_Talented t = new GuoJia_Talented();
		ACard card = new PeachCard();
		t.talented(p1, card);
		Assert.assertEquals(hands(card), p1.getHands());
	}
	
	@Test
	// This skill talented can be use just at check stage
	public void testGuojiaCanUseTalented()
	{
		APlayer p1 = new Player();
		APlayer p2 = new Player();
		ACard dodgeCard = new DodgeCard();
		p1.gameState = GameState.check;
		p1.setMaxHP(3);
		p1.setCurrentHP(3);
		p1.setName(HeroName.GuoJia);
		ISkill t = new GuoJia_Talented();
		p1.setSkill(t);
		Assert.assertEquals(true, p1.checkSkill(Arrays.asList(dodgeCard), Arrays.asList(p2)));
		
	}
	
	@Test
	//Test Talented can not be triggered since the gameState is not check
	public void testGuoJiaCannotUseTalented1()
	{
		APlayer p1 = new Player();
		APlayer p2 = new Player();
		ACard dodgeCard = new DodgeCard();
		p1.gameState = GameState.begin;
		p1.setMaxHP(3);
		p1.setCurrentHP(3);
		p1.setName(HeroName.GuoJia);
		ISkill t = new GuoJia_Talented();
		p1.setSkill(t);
		Assert.assertEquals(false, p1.checkSkill(Arrays.asList(dodgeCard), Arrays.asList(p2)));
	}
	
	@Test
	//Test Talented can not be triggered since the player do not need to check at check stage
	public void testGuoJiaCannotUseTalented2()
	{
		APlayer p1 = new Player();
		APlayer p2 = new Player();
		ACard checkCard = null;
		p1.gameState = GameState.check;
		p1.setMaxHP(3);
		p1.setCurrentHP(3);
		p1.setName(HeroName.GuoJia);
		ISkill t = new GuoJia_Talented();
		p1.setSkill(t);
		Assert.assertEquals(false, p1.checkSkill(Arrays.asList(checkCard), Arrays.asList(p2)));
	}
	
}
