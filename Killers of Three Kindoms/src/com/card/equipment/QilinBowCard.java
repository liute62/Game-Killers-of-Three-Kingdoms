package com.card.equipment;

import com.card.interfaces.IWeaponCard;
import com.card.interfaces.WeaponCard;
import com.system.constants.CardConst;

public class QilinBowCard extends WeaponCard implements IWeaponCard {
    public QilinBowCard() {
        this.name = "QilinBow";
        this.type = CardConst.CardType_Weapon;
        this.attackRange = 5;
    }

    @Override
    public void checkArmor() {

    }
}
