package com.card.equipment;

import java.util.List;

import com.card.interfaces.IWeaponCard;
import com.card.interfaces.WeaponCard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.ResUtil;

public class QilinBowCard extends WeaponCard implements IWeaponCard {
    public QilinBowCard() {
        this.name = "QilinBow";
        this.type = CardConst.CardType_Weapon;
        this.profile = ResUtil.getImgByName("weapon_qilinbow", 1);
        this.attackRange = 5;
    }

    @Override
    public void checkArmor() {

    }
    
    @Override
    public void use(APlayer player, List<APlayer> target) {
    	// TODO Auto-generated method stub
    	super.use(player, target);
    	player.getDeckEquipmentPanel().setAEquipment(this);
    }
}
