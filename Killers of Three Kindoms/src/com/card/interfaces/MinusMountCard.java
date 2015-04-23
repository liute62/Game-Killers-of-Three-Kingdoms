package com.card.interfaces;

import com.logic.player.APlayer;

import java.util.List;

public abstract class MinusMountCard extends AEquipmentCard implements IMountCard {
    public void use(APlayer player, List<APlayer> target)
    {
        for(APlayer targetPlayer: target)
        {
            targetPlayer.setMount(this);
        }
    }
    public abstract int getAffectedRange();
}
