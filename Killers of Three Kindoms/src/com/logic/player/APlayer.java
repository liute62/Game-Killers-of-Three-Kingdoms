package com.logic.player;

import java.util.ArrayList;
import java.util.List;

import com.card.interfaces.*;
import com.logic.interfaces.IPlayer;
import com.system.constants.CardConst;
import com.system.enums.GameState;

public abstract class APlayer implements IPlayer{

	 protected int maxHP;

	protected int currentHP;
	 protected List<ACard> hands;
	 protected  AmorCard amor;
	 protected PlusMountCard plusMount;
     protected MinusMountCard minusMount;
	 protected WeaponCard weapon;
	 protected int attackRange;
	 protected int position;
	 public GameState gameState;
	


	protected int drawCardNum = 2;
	protected int discardNum = 0;
	 
	 public List<ACard> getAvailableCards(List<ACard> cards){ 
		 if(gameState == GameState.begin || gameState == gameState.check || gameState == GameState.drawCard){
			 return new ArrayList<ACard>();
		 }if(gameState == GameState.castCard){
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
	 
	 public int getMaxHP() {
		 return maxHP;
	 }
	 
	 public void setMaxHP(int maxHP) {
		 this.maxHP = maxHP;
	 }
	 
	 public void setCurrentHP(int i) {
			// TODO Auto-generated method stub
			this.currentHP = i;
		}

	 public int getCurrentHP() {
			// TODO Auto-generated method stub
			return this.currentHP;
		}
	 
	 public AmorCard getAmor()
	 {
		 return this.amor;
	 }
	 
	 public void setAmor(AmorCard amor)
	 {
		 this.amor = amor;
	 }
		 
	 public PlusMountCard getPlusMount() {
		 return plusMount;
	 }
	 
	 public void setPlusMount(PlusMountCard mount) {
		 this.plusMount = mount;
	 }

     public MinusMountCard getMinusMount() {
        return minusMount;
    }

     public void setMinusMount(MinusMountCard mount) {
        this.minusMount = mount;
    }
	 
	 public WeaponCard getWeapon() {
		 return weapon;
	 }
	 
	 public void setWeapon(WeaponCard weapon) {
		 this.weapon = weapon;
	 }
	 
	 public int getAttackRange() {
		 return attackRange;
	 }
	 
	 public void setAttackRange(int attackRange) {
		 this.attackRange = attackRange;
	 }
	 
	 public List<ACard> getHands() {
			// TODO Auto-generated method stub
			return this.hands;
	}

	 public void setHands(List<ACard> list) {
			// TODO Auto-generated method stub
			this.hands = list;
	}
	 
	 public void setDrawCardNum(int num){
		 this.drawCardNum = num;
	 }
	 
	 public int getDrawCardNum(){
		 return this.drawCardNum;
	 }
	 
	 public void setDiscardNum(int num){
		 this.discardNum = num;
	 }
	 
	 public int getDiscardNum(){
		 return this.discardNum;
	 }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
 
}
