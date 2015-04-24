package com.card.equipment;

import com.card.interfaces.IMountCard;
import com.card.interfaces.MinusMountCard;
import com.system.constants.CardConst;

public class RedHareCard extends MinusMountCard implements IMountCard {
    public RedHareCard() {
        this.name = "RedHare";
        this.type = CardConst.CardType_Mount_Minus;
    }
    private int affectedRange = 1;

    @Override
    public int getAffectedRange() {
        return affectedRange;
    }
}
