package com.logic.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.interfaces.IPlayer;
import com.logic.test.PlayerInitializationTest;
import com.system.enums.HeroName;
import com.system.enums.RoleType;

public class Player extends APlayer{
     public Player() {
        // TODO Auto-generated constructor stub
         this.attackRange = 1;
         this.hands = new ArrayList<ACard>();
    }
     
    
//    public Player(String heroName, int roleType) {
//		// TODO Auto-generated constructor stub
//    	this.heroName = heroName;
//    	this.roleType = roleType;
//    	this.attackRange = 1;
//        this.hands = new ArrayList<ACard>();
//	}
//    
//    public void initializePlayerInfo() {
//    	if(this.roleType == 1)
//    	{
//    		this.maxHP = Database.getMaxHP(this.heroName) + 1;
//    	}
//    	else 
//    	{
//    		this.maxHP = Database.getMaxHP(this.heroName);
//		}
//    }

	public Player(HeroName name, RoleType roleType) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.roleType = roleType;
		this.attackRange = 1;
	}


	@Override
    public boolean strike(IPlayer target) {
        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public boolean dodge() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void peach() {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean ifDropCards() {
        int numOfHands = this.hands.size();
        if(numOfHands < this.currentHP) {
            return false;
        }
        else {
            return true;
        }

    }

    /**
     * @param num the number of HP to lose
     */
    @Override
    public void loseHP(int num) {
        // TODO Auto-generated method stub
        this.currentHP -= num;
    }

    public void gainHP(int num) {
    	if(this.currentHP < this.maxHP)
        this.currentHP += num;
    }

    public void dropCards(ArrayList<Integer> idList) {

    }

    @Override
    public void drawACard() {
        // TODO Auto-generated method stub
        List<ACard> handCards = getHands();
        if(handCards == null){
            handCards = new ArrayList<ACard>();
        }
        ACard card = null;
        handCards.add(card);
        setHands(handCards);
    }


	@Override
	public void initializePlayerInfo() {
		// TODO Auto-generated method stub
		if(this.roleType == RoleType.Monarch)
	    {
			this.maxHP = Database.getMaxHP(this.name) + 1;
	    }
		else 
		{
    		this.maxHP = Database.getMaxHP(this.name);
		}
	}
	
	

}
