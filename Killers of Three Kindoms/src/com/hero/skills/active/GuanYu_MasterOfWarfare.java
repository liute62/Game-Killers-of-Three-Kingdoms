package com.hero.skills.active;

import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;
import com.system.constants.SuitConst;
import com.system.enums.HeroName;

import java.util.List;

public class GuanYu_MasterOfWarfare implements ISkill {

    @Override
    public void use(APlayer operator, List<ACard> cards, List<APlayer> players) {
        (new StrikeCard()).use(operator, players);
        operator.getHands().removeAll(cards);
    }

    @Override
    public boolean check(APlayer operator, List<ACard> cards, List<APlayer> players) {
        int numOfCards = cards.size();
        int numOfPlayers = players.size();
        if (numOfCards == 0 || numOfPlayers == 0 || numOfCards > 1) {
            return false;
        }
        return operator.getName().equals(HeroName.GuanYu)
                && cards.get(0).getSuit() != SuitConst.SuitType_Spades
                && cards.get(0).getSuit() != SuitConst.SuitType_Clubs
                && (new StrikeCard()).checkTarget(operator, players);
    }
}
