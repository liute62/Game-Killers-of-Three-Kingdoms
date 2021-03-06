package com.card.base;

import java.util.List;

import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.ResUtil;

public class PeachCard extends ACard{

	public  PeachCard() {
		this.name = "Peach";
		this.type = CardConst.CardType_Peach;
        this.profile = ResUtil.getImgByName("basic_peach", 1);
    }

	/**
	 * The process of Peach
	 * Recover 1 health for target
	 * @author Xiangtian Li
	 */
	@Override
	public void use(APlayer player, List<APlayer> targets) {
		// TODO Auto-generated method stub
		for(APlayer target: targets)
		{
			target.gainHP(1);
			target.updateGuiHP();
		}
	}

}
