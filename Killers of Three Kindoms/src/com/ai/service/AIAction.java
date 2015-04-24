package com.ai.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.enums.GameState;
import com.system.utils.DebugUtil;

public class AIAction {

	private APlayer player;
	private int castCardIndex;
	private List<ACard> availableCards;
	public AIAction(APlayer player){
		this.setPlayer(player);
	}
	
	/**
	 * Draw card stage for AI. 
	 */
	public void drawCard(){
		int num = player.getDrawCardNum();
		for (int i = 0; i < num; i++) {
			player.drawACard();	
		}
		if(player.getHands() == null){
			List<ACard> cards = new ArrayList<ACard>();
			player.setHands(cards);
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
		player.gameState = GameState.castCard;
		List<ACard> cards = player.getAvailableCards(player.getHands());
		setAvailableCards(cards);
		player.setBeingUsedCard(cards.get(castCardIndex));
	}
	
	/**
	 * Drop card stage for AI
	 */
	public void dropCard(){
		int num = player.getDiscardNum();
		List<ACard> tmp = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			tmp.add(player.getHands().get(i));
		}
		player.getHands().removeAll(tmp);
	}

	public APlayer getPlayer() {
		return player;
	}

	public void setPlayer(APlayer player) {
		this.player = player;
	}

	public int getCastCardIndex() {
		return castCardIndex;
	}

	public void setCastCardIndex(int castCardIndex) {
		this.castCardIndex = castCardIndex;
	}

	public List<ACard> getAvailableCards() {
		return availableCards;
	}

	public void setAvailableCards(List<ACard> availableCards) {
		this.availableCards = availableCards;
	}
}
