package com.card.base;

import java.util.List;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;

public class PeachCard extends ACard{

	public  PeachCard() {
		this.name = "Peach";
		this.type = CardConst.CardType_Peach;
	}

	/**
	 * The process of Peach
	 * Recover 1 health for target
	 * @author Xiangtian Li
	 */
	@Override
	public void use(APlayer player, List<APlayer> target) {
		// TODO Auto-generated method stub
		for(APlayer targert: target)
		{
			targert.gainHP(1);
		}
	}

}
