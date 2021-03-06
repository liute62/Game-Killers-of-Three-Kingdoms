package com.logic.interfaces;

import java.util.ArrayList;

import com.logic.player.APlayer;

public interface IPlayer {

	boolean strike(IPlayer target);
	
	boolean dodge();
	
	void peach();
	
	void loseHP(int n);
	
	void gainHP(int n);
	
	boolean ifDropCards();
	
	void dropCards(ArrayList<Integer> idList);
	
	void drawACard();
	
	void initializePlayerInfo();
	
	void playerProcess();
	
	void updateDiscardNum();
}