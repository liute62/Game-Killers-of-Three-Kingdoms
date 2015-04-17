package com.card.base;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.utils.PlayerUtil;

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
     * 1.check for distance;
     * 2.check for death
     *
     * @param player attacker
     * @param targets list of players
     * @return true  yes,target can be struck.
     * false no,target can not be struck.
     */
    public boolean checkTarget(APlayer player, List<APlayer> targets) {
        PlayerUtil playerUtil = new PlayerUtil();
        for (APlayer target : targets) {
            if (player.getAttackRange() == 1
                    && playerUtil.getDistance(player, target) > 1) {
                return false;
            }
            if (target.getCurrentHP() == 0) {
                return false;
            }
        }
        return true;
    }

}
