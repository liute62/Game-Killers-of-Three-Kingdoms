package com.logic.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.card.interfaces.ACard;

public class Player extends APlayer{

	
	@Override
	public boolean strike() {
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
		this.currentHP += num;
	}
	
	public List<ACard> getHands() {
		// TODO Auto-generated method stub
		return this.hands;
	}

	public void setHands(List<ACard> list) {
		// TODO Auto-generated method stub
		this.hands = list;
	}

	public void dropCards(ArrayList<Integer> idList) {
		
	
	}
}
