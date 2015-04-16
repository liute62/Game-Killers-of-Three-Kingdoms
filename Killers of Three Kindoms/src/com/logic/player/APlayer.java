package com.logic.player;
import java.util.ArrayList;
import java.util.List;
import com.card.interfaces.ACard;
import com.logic.interfaces.IPlayer;

public abstract class APlayer implements IPlayer{

	 protected int currentHP;
	 public List<ACard> getAvailableCards(List<ACard> cards) 
	 {
		return new ArrayList<ACard>();
	 }

	 protected List<ACard> hands;
} 