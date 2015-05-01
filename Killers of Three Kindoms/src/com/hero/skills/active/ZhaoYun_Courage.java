package com.hero.skills.active;

import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.enums.HeroName;

import java.util.List;

public class ZhaoYun_Courage implements ISkill {

    @Override
    public void use(APlayer operator, List<ACard> cards, List<APlayer> players) {

    }

    @Override
    public boolean check(APlayer operator, List<ACard> cards, List<APlayer> players) {
        int numOfCards = cards.size();
        if (numOfCards == 0) {
            return false;
        }
        return operator.getName().equals(HeroName.ZhaoYun)
                && (cards.get(0).getType() == CardConst.CardType_Dodge
                || cards.get(0).getType() == CardConst.CardType_Strike);
    }
}
