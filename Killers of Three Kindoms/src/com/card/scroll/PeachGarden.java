package com.card.scroll;

import java.util.ArrayList;
import java.util.List;

import com.logic.player.APlayer;

//Play Phase.
//Target: All Heroes.
//Effect: All Heroes regain 1 unit of life in turn order, starting with the Hero who used this card.

public class PeachGarden extends ScrollCardAbstract {
	
	private List<APlayer> orderOfRecovering;
	
	public List<APlayer> getOrderOfRecovering() {
		return orderOfRecovering;
	}

	public void setOrderOfRecovering(List<APlayer> orderOfRecovering) {
		this.orderOfRecovering = orderOfRecovering;
	}

	public void use(APlayer player,List<APlayer> target)
	{
		this.orderOfRecovering = new ArrayList<APlayer>();
		for(APlayer targetPlayer: target)
		{
			targetPlayer.gainHP(1);
		}
	}
}
