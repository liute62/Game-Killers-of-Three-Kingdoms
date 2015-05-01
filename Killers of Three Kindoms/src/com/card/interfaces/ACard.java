package com.card.interfaces;


public abstract class ACard implements ICard {

    protected int id;

    protected int number;

    protected String name;

    protected int type;



    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
