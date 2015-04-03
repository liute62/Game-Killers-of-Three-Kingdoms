package com.logic.player;

import java.util.List;

import com.card.interfaces.ACard;
import com.logic.interfaces.IPlayer;

public abstract class APlayer implements IPlayer{

	 protected int currentHP;
	 
	 protected List<ACard> hands;
} 
