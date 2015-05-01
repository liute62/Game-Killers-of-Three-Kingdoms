package com.hero.skills.active;

import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;
import com.system.constants.SuitConst;
import com.system.enums.HeroName;

import java.util.List;

public class GuanYu_MasterOfWarfare implements ISkill {

    @Override
    public void use(APlayer operator, List<ACard> cards, List<APlayer> players) {

    }

    @Override
    public boolean check(APlayer operator, List<ACard> cards, List<APlayer> players) {
        return operator.getName().equals(HeroName.GuanYu)
                && cards.get(0).getSuit() != SuitConst.SuitType_Spades
                && cards.get(0).getSuit() != SuitConst.SuitType_Clubs;
    }
}
