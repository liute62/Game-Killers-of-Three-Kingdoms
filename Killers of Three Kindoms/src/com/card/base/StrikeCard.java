package com.card.base;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.PlayerUtil;
import com.system.utils.ResUtil;

import java.util.List;

public class StrikeCard extends ACard {

    public StrikeCard() {
        this.name = "Strike";
        this.type = CardConst.CardType_Strike;
        this.profile = ResUtil.getImgByName("basic_strike", 1);
    }

    /**
     * The process of striking
     * 1.check the weapon effect if player has a weapon.
     * 2.check the armor effect.
     * 3.calculate the number of damage.
     */
    @Override
    public void use(APlayer player, List<APlayer> targets) {
        // TODO Auto-generated method stub
    	boolean ignoreAmor = false; //Ignore target's armor card if it is true

        // TODO Check weapon: if Qilin Bow then remove the target's mount
    	// TODO Check weapon: if BlackPommel then ignore target's amor
        for (APlayer target: targets) {
            if (player.getWeapon() != null
                    && player.getWeapon().getName().equals("QilinBow")) {
                target.setPlusMount(null);
                target.setMinusMount(null);
                target.getDeckEquipmentPanel().removeMount(0);
                target.getDeckEquipmentPanel().removeMount(1);
            }
            if(player.getWeapon() != null && player.getWeapon().getName().equals("BlackPommel")) {
            	ignoreAmor = true;
            } 
        }
        
        for (APlayer target: targets) {
            if(ignoreAmor) {
            	target.loseHP(1);
            	target.updateGuiHP();
            }
            else {
            	target.loseHP(1);
            	target.updateGuiHP();
			}
        }
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
        PlayerUtil playerUtil = PlayerUtil.getInstance();
        for (APlayer target : targets) {
            if (player.getAttackRange() == 1
                    && playerUtil.getDistance(player, target) > 1) {
                return false;
            }
            if (target.getCurrentHP() <= 0) {
                return false;
            }
        }
        return true;
    }

}
