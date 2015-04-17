package com.ai.service;

import com.logic.player.APlayer;

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
		
	}

	public APlayer getPlayer() {
		return player;
	}

	public void setPlayer(APlayer player) {
		this.player = player;
	}
}
