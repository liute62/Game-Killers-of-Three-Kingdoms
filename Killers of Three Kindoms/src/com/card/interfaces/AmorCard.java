package com.card.interfaces;

import java.util.List;

import com.logic.player.APlayer;

public abstract class AmorCard extends AEquipmentCard{
	public void use(APlayer player,List<APlayer> target) {
		for(APlayer targetPlayer: target)
		{
			targetPlayer.setAmor(this);
		}
	}
	
}
