package com.card.equipment;

import com.card.interfaces.IMountCard;
import com.card.interfaces.PlusMountCard;
import com.system.constants.CardConst;

public class ShadowRunnerCard extends PlusMountCard implements IMountCard {
	public ShadowRunnerCard() {
        this.name = "ShadowRunner";
        this.type = CardConst.CardType_Mount_Plus;
    }
    private int affectedRange = 1;

    @Override
    public int getAffectedRange() {
        return affectedRange;
    }
}
