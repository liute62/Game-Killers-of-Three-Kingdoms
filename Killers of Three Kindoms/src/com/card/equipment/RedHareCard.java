package com.card.equipment;

import com.card.interfaces.IMountCard;
import com.card.interfaces.MinusMountCard;
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
}
