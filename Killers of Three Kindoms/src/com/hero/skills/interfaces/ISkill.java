package com.hero.skills.interfaces;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;

import java.util.List;

public interface ISkill {
    public void use(APlayer operator, List<ACard> cards, List<APlayer> players);
    public boolean check(APlayer operator, List<ACard> cards, List<APlayer> players);
}
