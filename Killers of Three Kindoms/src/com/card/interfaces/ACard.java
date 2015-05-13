package com.card.interfaces;


import java.awt.image.BufferedImage;

public abstract class ACard implements ICard {

    protected int id;

    protected int number;

    protected String name;

    protected int type;

    protected int suit;

    protected BufferedImage profile;

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

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

    public String getName() {
        return name;
    }

    public BufferedImage getProfile() {
        return profile;
    }

    public void setProfile(BufferedImage profile) {
        this.profile = profile;
    }
}
