package com.card.base;

import java.util.List;

import com.card.interfaces.ACard;
import com.gui.gaming.MessagePanel;
import com.logic.player.APlayer;
import com.system.constants.CardConst;

public class DodgeCard extends ACard{

	public DodgeCard(){
		this.name = "Dodge";
		this.type = CardConst.CardType_Dodge;
	}

	@Override
	public void use(APlayer player, List<APlayer> target) {
		// TODO Auto-generated method stub
		
	}

}

