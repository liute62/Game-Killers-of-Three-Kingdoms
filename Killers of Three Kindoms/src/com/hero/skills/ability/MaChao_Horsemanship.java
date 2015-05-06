package com.hero.skills.ability;

import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;

import java.util.List;

public class MaChao_Horsemanship implements ISkill {

    @Override
    public void use(APlayer operator, List<ACard> cards, List<APlayer> players) {

    }

    @Override
    public boolean check(APlayer operator, List<ACard> cards, List<APlayer> players) {
        return false;
    }
}
