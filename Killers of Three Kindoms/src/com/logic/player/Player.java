package com.logic.player;

public class Player extends APlayer{

	public int getCurrentHP()
	{
		return currentHP;
	}
	
	public void setCurrentHP(int health) {
		this.currentHP = health;
	}
	
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

	

}
