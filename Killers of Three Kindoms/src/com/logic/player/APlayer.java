package com.logic.player;

import com.card.interfaces.ACard;
import com.logic.interfaces.IPlayer;
import com.system.constants.CardConst;
import com.system.enums.GameState;

import java.util.ArrayList;
import java.util.List;

public abstract class APlayer implements IPlayer {

    protected int position;
    protected int attackRange;
    protected int currentHP;
    protected List<ACard> hands;
    public GameState gameState;

    public List<ACard> getAvailableCards(List<ACard> cards) {
        if (gameState == GameState.begin || gameState == gameState.check || gameState == GameState.drawCard) {
            return new ArrayList<ACard>();
        }
        if (gameState == GameState.castCard) {
            List<ACard> listType = new ArrayList<ACard>();
            for (ACard c : cards) {
                if (c != null && c.getType() == CardConst.CardType_Dodge) {
                    listType.add(c);
                }
            }
            cards.removeAll(listType);
        }
        return cards;
    }

    public void setCurrentHP(int i) {
        this.currentHP = i;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }
}