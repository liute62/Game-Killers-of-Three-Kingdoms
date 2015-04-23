package com.card.equipment;

import com.card.interfaces.IMountCard;
import com.card.interfaces.MinusMountCard;

public class RedHare extends MinusMountCard implements IMountCard {
    public RedHare() {

    }
    private int affectedRange = 1;

    @Override
    public int getAffectedRange() {
        return affectedRange;
    }
}
