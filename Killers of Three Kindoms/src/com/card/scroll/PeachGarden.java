package com.card.scroll;

import java.util.List;

import com.logic.player.APlayer;

//Play Phase
//Target: All Heroes
//Effect: All Heroes regain 1 unit of life in turn order, starting with the Hero who used this card.
public class PeachGarden extends ScrollCardAbstract {
	
	
	public void use(APlayer player,List<APlayer> target)
	{
		for(APlayer targetPlayer: target)
		{
			int currentHP = targetPlayer.getCurrentHP(); 
			targetPlayer.setCurrentHP(currentHP+1);
		}
	}
}
