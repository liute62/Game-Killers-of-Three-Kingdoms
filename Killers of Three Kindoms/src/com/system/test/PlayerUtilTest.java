package com.system.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.gui.gaming.CardPanel;
import com.gui.gaming.OtherPlayerPanel;
import com.logic.player.APlayer;
import com.system.utils.PlayerUtil;

public class PlayerUtilTest {
	PlayerUtil playerUtil;
	List<APlayer> expectTargetPlayers;
	@Before
	public void initial()
	{
		this.playerUtil = PlayerUtil.getInstance();
		this.expectTargetPlayers = new ArrayList<APlayer>();
	}
	
	@Test
	public void testGetTargetPlayersWhenCardRangeIs1() {
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(1));
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(4));
		
		List<APlayer> actualTargetPlayers = new ArrayList<APlayer>();
		ACard card = new StrikeCard();
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.setEffectRange(1);
		actualTargetPlayers = cardPanel.getTargetPlayers();
		Assert.assertEquals(expectTargetPlayers, actualTargetPlayers);
	}
	
	@Test
	public void testGetTargetPlayersWhenCardRangeIs2() {
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(1));
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(2));
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(3));
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(4));
		
		List<APlayer> actualTargetPlayers = new ArrayList<APlayer>();
		ACard card = new StrikeCard();
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.setEffectRange(2);
		actualTargetPlayers = cardPanel.getTargetPlayers();
		Assert.assertEquals(expectTargetPlayers, actualTargetPlayers);
	}
	
	@Test
	public void testGetTargetPlayersWhenCardRangeIs3() {
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(1));
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(2));
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(3));
		this.expectTargetPlayers.add(playerUtil.getPlayers().get(4));
		
		List<APlayer> actualTargetPlayers = new ArrayList<APlayer>();
		ACard card = new StrikeCard();
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.setEffectRange(3);
		actualTargetPlayers = cardPanel.getTargetPlayers();
		Assert.assertEquals(expectTargetPlayers, actualTargetPlayers);
	}
	
	@Test
	public void testCheckEffectRangeForStirkeCard1() {
		APlayer p1 = PlayerUtil.getInstance().getPlayer();
		p1.setAttackRange(1);
		int expectRange = p1.getAttackRange();
		ACard card = new StrikeCard();
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.checkEffectRange();
		Assert.assertEquals(expectRange, cardPanel.getEffectRange());
	}
	
	@Test
	public void testCheckEffectRangeForStirkeCard2() {
		APlayer p1 = PlayerUtil.getInstance().getPlayer();
		p1.setAttackRange(2);
		int expectRange = p1.getAttackRange();
		ACard card = new StrikeCard();
		CardPanel cardPanel = new CardPanel(card);
		cardPanel.checkEffectRange();
		Assert.assertEquals(expectRange, cardPanel.getEffectRange());
	}
	
}
