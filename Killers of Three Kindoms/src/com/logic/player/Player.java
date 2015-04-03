package com.logic.player;

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

	/**
	 * @param num the number of HP to lose
	 */
	@Override
	public void loseHP(int num) {
		// TODO Auto-generated method stub
		
	}

	public void setCurrentHP(int i) {
		// TODO Auto-generated method stub
		this.currentHP = i;
	}

	public Object getCurrentHP() {
		// TODO Auto-generated method stub
		return this.currentHP;
	}

}
