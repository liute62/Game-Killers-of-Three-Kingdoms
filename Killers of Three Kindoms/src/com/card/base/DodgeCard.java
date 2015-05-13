package com.card.base;

import java.util.List;

import com.card.interfaces.ACard;
import com.gui.gaming.MessagePanel;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.ResUtil;

public class DodgeCard extends ACard{

	public DodgeCard(){
		this.name = "Dodge";
		this.type = CardConst.CardType_Dodge;
        this.profile = ResUtil.getImgByName("basic_dodge", 1);
	}

	@Override
	public void use(APlayer player, List<APlayer> target) {
		// TODO Auto-generated method stub
		
	}

}

