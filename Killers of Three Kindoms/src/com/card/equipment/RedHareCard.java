package com.card.equipment;

import java.util.List;

import com.card.interfaces.IMountCard;
import com.card.interfaces.MinusMountCard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.ResUtil;

public class RedHareCard extends MinusMountCard implements IMountCard {
    public RedHareCard() {
        this.name = "RedHare";
        this.type = CardConst.CardType_Mount_Minus;
        this.profile = ResUtil.getImgByName("mount_redhare", 1);
    }
    private int affectedRange = 1;

    @Override
    public int getAffectedRange() {
        return affectedRange;
    }
    
    @Override
    public void use(APlayer player, List<APlayer> target) {
    	// TODO Auto-generated method stub
    	super.use(player, target);
    	player.getDeckEquipmentPanel().setAEquipment(this);
    }
}
