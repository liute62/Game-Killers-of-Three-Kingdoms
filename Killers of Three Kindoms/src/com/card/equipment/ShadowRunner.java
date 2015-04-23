package com.card.equipment;

import com.card.interfaces.IMountCard;
import com.card.interfaces.PlusMountCard;

public class ShadowRunner extends PlusMountCard implements IMountCard {
	public ShadowRunner() {

    }
    private int affectedRange = 1;

    @Override
    public int getAffectedRange() {
        return affectedRange;
    }
}
