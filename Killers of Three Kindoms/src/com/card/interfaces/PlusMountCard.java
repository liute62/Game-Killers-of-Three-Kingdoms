package com.card.interfaces;

import java.util.List;
import com.logic.player.APlayer;

public abstract class PlusMountCard extends AEquipmentCard implements IMountCard {
	public void use(APlayer player, List<APlayer> target)
	{
		for(APlayer targetPlayer: target)
		{
			targetPlayer.setMount(this);
		}
	}
}
