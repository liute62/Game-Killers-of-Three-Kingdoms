package com.card.interfaces;


public abstract class CardAbstract implements CardInterface{

	protected int id;
	
	protected int number;
	
	protected String name;
	
	public void setId(int id){
		this.id = id;
	}
}
