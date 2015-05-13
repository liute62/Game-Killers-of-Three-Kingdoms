package com.card.equipment;

import com.card.interfaces.IMountCard;
import com.card.interfaces.PlusMountCard;
import com.system.constants.CardConst;
import com.system.utils.ResUtil;

public class ShadowRunnerCard extends PlusMountCard implements IMountCard {
	public ShadowRunnerCard() {
        this.name = "ShadowRunner";
        this.type = CardConst.CardType_Mount_Plus;
        this.profile = ResUtil.getImgByName("mount_shadowrunner", 1);
    }
    private int affectedRange = 1;

    @Override
    public int getAffectedRange() {
        return affectedRange;
    }
}
