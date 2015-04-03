package com.logic.interfaces;

import com.logic.player.APlayer;

public interface IPlayer {

	boolean strike();
	
	boolean dodge();
	
	void peach();
	
	void loseHP(int n);
	
	boolean ifDropCards();
}
