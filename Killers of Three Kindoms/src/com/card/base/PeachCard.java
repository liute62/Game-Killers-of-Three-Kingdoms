package com.card.base;

import java.util.List;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;

public class PeachCard extends ACard{

	public  PeachCard() {
		this.name = "Peach";
		drawCard();
	}
	
	private void drawCard(){
		
	}

	@Override
	public void use(APlayer player, List<APlayer> target) {
		// TODO Auto-generated method stub
		
	}

}
