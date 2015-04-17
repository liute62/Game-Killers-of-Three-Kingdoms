package com.card.base;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;

import java.util.List;

public class StrikeCard extends ACard {

    public StrikeCard() {
        this.name = "Strike";
    }

    /**
     * The process of striking
     * 1.check the weapon effect if player has a weapon.
     * 2.check the armor effect.
     * 3.calculate the number of damage.
     */
    @Override
    public void use(APlayer player, List<APlayer> target) {
        // TODO Auto-generated method stub

    }

    /**
     * To check whether player can strike the target.
     * 1.check for death;
     * 2.check for distance
     *
     * @param players a list of player
     * @return true  yes,target can be struck.
     * false no,target can not be struck.
     */
    public boolean checkTarget(List<APlayer> players) {
        return true;
    }

}
