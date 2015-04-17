package com.logic.player;

import java.util.ArrayList;
import java.util.List;

import com.card.interfaces.ACard;
import com.card.interfaces.AmorCard;
import com.card.interfaces.MountCard;
import com.logic.interfaces.IPlayer;
import com.system.constants.CardConst;
import com.system.enums.GameState;

public abstract class APlayer implements IPlayer{

	 protected int currentHP;
	 protected List<ACard> hands;
	 public GameState gameState;
	 protected  AmorCard amor;
	 protected MountCard mount;
	 

	protected int drawCardNum = 2;
	 
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
		 
	 public MountCard getMount() {
		 return mount;
	 }
	 
	 public void setMount(MountCard mount) {
		 this.mount = mount;
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
}