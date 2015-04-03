package com.logic.player;

import java.util.List;

import org.easymock.internal.matchers.Null;

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
		return false;
		
	}
	
	/**
	 * @param num the number of HP to lose
	 */
	@Override
	public void loseHP(int num) {
		// TODO Auto-generated method stub
		this.currentHP -= num;
	}

	public void setCurrentHP(int i) {
		// TODO Auto-generated method stub
		this.currentHP = i;
	}

	public int getCurrentHP() {
		// TODO Auto-generated method stub
		return this.currentHP;
	}

	
	public List<ACard> getHands() {
		// TODO Auto-generated method stub
		return this.hands;
	}

	public void setHands(List<ACard> list) {
		// TODO Auto-generated method stub
		this.hands = list;
	}

}
