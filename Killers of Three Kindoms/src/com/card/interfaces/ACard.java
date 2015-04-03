package com.card.interfaces;


public abstract class ACard implements ICard{

	protected int id;
	
	protected int number;
	
	protected String name;
	
	public void setId(int id){
		this.id = id;
	}

    public int getId() {
        return this.id;
    }
}
