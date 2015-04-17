package com.ai.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.utils.DebugUtil;

public class AIAction {

	private APlayer player;
	
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
	 * 1.check target
	 * 2.cast a card (algorithm for casting what card)
	 */
	public void castCard(){
		
	}
	
	/**
	 * Drop card stage for AI
	 */
	public void dropCard(){
		player.getHands().remove(0);
	}

	public APlayer getPlayer() {
		return player;
	}

	public void setPlayer(APlayer player) {
		this.player = player;
	}
}
