package com.hero.skills.active;

import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;

import java.util.List;

public class ZhaoYun_Courage implements ISkill {

    @Override
    public void use(List<ACard> cards, List<APlayer> players) {

    }

    @Override
    public boolean check(List<ACard> cards, List<APlayer> players) {
        return true;
    }
}
