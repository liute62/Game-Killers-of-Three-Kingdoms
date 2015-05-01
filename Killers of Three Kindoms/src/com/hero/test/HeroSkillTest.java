package com.hero.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.card.base.PeachCard;
import com.card.interfaces.ACard;
import com.hero.skills.trigger.GuoJia_Talented;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class HeroSkillTest {
	APlayer p1;
	
	private List<ACard> hands(ACard...cards) {
        return Arrays.asList(cards);
    }
	
	@Before
	public void initializePlayer()
	{
		this.p1 = new Player();
	}
	
	@Test
	public void testTalented()
	{
		GuoJia_Talented t = new GuoJia_Talented();
		ACard card = new PeachCard();
		t.talented(p1, card);
		Assert.assertEquals(hands(card), p1.getHands());
	}
}
