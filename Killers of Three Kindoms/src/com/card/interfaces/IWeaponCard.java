package com.card.interfaces;

import com.logic.player.APlayer;

public interface IWeaponCard {

	//something is related to weapon's features
	
	//Black Pommel
	public void checkArmor();
	
	
	//All weapon can extend player's attack range
	public void setAttackRange(APlayer player);
}
