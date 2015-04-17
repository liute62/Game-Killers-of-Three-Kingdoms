package com.card.interfaces;

import java.util.List;

import com.logic.player.APlayer;

public interface ICard {

	//some same functionality
	//for example
	/**
	 * 
	 * @param player someone use this card.
	 * @param target someone be targeted.
	 */
	void use(APlayer player,List<APlayer> target);
}
