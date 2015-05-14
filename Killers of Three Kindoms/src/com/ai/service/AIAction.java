package com.ai.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.card.interfaces.ACard;
import com.card.interfaces.AmorCard;
import com.gui.gaming.BattleFieldPanel;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.constants.CardConst;
import com.system.enums.GameStage;
import com.system.utils.DebugUtil;
import com.system.utils.PlayerUtil;

public class AIAction {

	private APlayer player;
	private int castCardIndex;
	private List<ACard> availableCards;
	private APlayer target;
	public AIAction(APlayer player){
		this.setPlayer(player);
		player.setTargetPlayer(PlayerUtil.getInstance().getPlayers().get(0));
	}
	
	public void process(){
		
	}
	
	/**
	 * Draw card stage for AI. 
	 */
	public void drawCard(){
		player.setDrawCardNum(2);
		int num = player.getDrawCardNum();
		for (int i = 0; i < num; i++) {
			player.drawACard();	
		}
		if(player.getHands() == null){
			List<ACard> cards = new ArrayList<ACard>();
			player.setHands(cards);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Cast card stage for AI.
	 * 1.get available card and randomly choose a card to use.
	 * 2.check the range of being used card, and get the available target.
	 * 3.there are 3 rule for choosing the target.
	 * 4.if AI's role is Monarch
	 * 5.if AI's role is
	 * 6.if AI's role is
	 * 7.then finish.
	 */
	public void castCard(){
		ACard cardToCast;
		APlayer targetPlayer;
		player.gameStage = GameStage.castCard;
		List<ACard> cards = player.getAvailableCards(player.getHands());
		setAvailableCards(cards);
		while(true)
		{
			cardToCast = IsThereWeapon(cards);
			if(cardToCast != null) break;
			cardToCast = IsThereAmor(cards);
			if(cardToCast != null) break;
			cardToCast = IsThereMount_minus(cards);
			if(cardToCast != null) break;
			cardToCast = IsThereMount_plus(cards);
			if(cardToCast != null) break;
			cardToCast = IsThereStrike(cards);
			if(cardToCast != null) break;
			cardToCast = IsTherePeach(cards);
			if(cardToCast != null) break;
			break;
		}
		this.player.setBeingUsedCard(cards.get(castCardIndex));
		//choose the available target
		targetPlayer = selectTarget(cardToCast);
		this.setTarget(targetPlayer);
		this.player.setTargetPlayer(this.target);
		cardToCast.use(this.player, Arrays.asList(targetPlayer));
		BattleFieldPanel.Instance().addACard(this.player, cardToCast);
	}

	/**
	 * Drop card stage for AI
	 */
	public void dropCard(){
		player.updateDiscardNum();
		int num = player.getDiscardNum();
		List<ACard> tmp = new ArrayList<ACard>();
		for (int i = 0; i < num; i++) {
			tmp.add(player.getHands().get(i));
		}
		player.getHands().removeAll(tmp);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void end(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		player.getOtherPlayerPanel().setDoing(false);
	}
	
	private APlayer selectTarget(ACard cardToCast) {
		// TODO Auto-generated method stub
		//List<APlayer> players = PlayerUtil.getInstance().getPlayers();
		if(cardToCast.getType() == CardConst.CardType_Armor || cardToCast.getType() == CardConst.CardType_Weapon
				|| cardToCast.getType() == CardConst.CardType_Mount_Minus || cardToCast.getType() == CardConst.CardType_Mount_Plus)
		{
			return this.player;
		}
		else if(cardToCast.getType() == CardConst.CardType_Strike)
		{
			List<APlayer> players = PlayerUtil.getInstance().getPlayers();
			for(APlayer player: players)
			{
				if(PlayerUtil.getDistance(this.player, player) == 1) return player;
			}
		}
		return null;
	}

	private ACard IsTherePeach(List<ACard> cards) {
		// TODO Auto-generated method stub
		for(int i = 0; i < availableCards.size(); i++ )
		{
			if(availableCards.get(i).getType() == CardConst.CardType_Peach)
			{
				this.castCardIndex = i;
				return availableCards.get(i);
			}
		}
		return null;
	}

	private ACard IsThereStrike(List<ACard> cards) {
		for(int i = 0; i < availableCards.size(); i++ )
		{
			if(availableCards.get(i).getType() == CardConst.CardType_Strike)
			{
				this.castCardIndex = i;
				return availableCards.get(i);
			}
		}
		return null;
	}

	private ACard IsThereMount_minus(List<ACard> cards) {
		for(int i = 0; i < availableCards.size(); i++ )
		{
			if(availableCards.get(i).getType() == CardConst.CardType_Mount_Minus)
			{
				this.castCardIndex = i;
				return availableCards.get(i);
			}
		}
		return null;
	}
	
	private ACard IsThereMount_plus(List<ACard> cards) {
		for(int i = 0; i < availableCards.size(); i++ )
		{
			if(availableCards.get(i).getType() == CardConst.CardType_Mount_Plus)
			{
				this.castCardIndex = i;
				return availableCards.get(i);
			}
		}
		return null;
	}

	private ACard IsThereAmor(List<ACard> cards) {
		for(int i = 0; i < availableCards.size(); i++ )
		{
			if(availableCards.get(i).getType() == CardConst.CardType_Armor)
			{
				this.castCardIndex = i;
				return availableCards.get(i);
			}
		}
		return null;
	}

	private ACard IsThereWeapon(List<ACard> availableCards)
	{
		for(int i = 0; i < availableCards.size(); i++ )
		{
			if(availableCards.get(i).getType() == CardConst.CardType_Weapon)
			{
				this.castCardIndex = i;
				return availableCards.get(i);
			}
		}
		return null;
	}

	public APlayer getPlayer() {
		return player;
	}

	public void setPlayer(APlayer player) {
		this.player = player;
	}


	public void setCastCardIndex(int castCardIndex) {
		this.castCardIndex = castCardIndex;
	}


	public void setAvailableCards(List<ACard> availableCards) {
		this.availableCards = availableCards;
	}

	public APlayer getTarget() {
		return target;
	}

	public void setTarget(APlayer target) {
		this.target = target;
	}
}
