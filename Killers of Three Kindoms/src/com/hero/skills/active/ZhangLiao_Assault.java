package com.hero.skills.active;

import java.util.List;
import java.util.Random;

import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;
import com.system.enums.GameStage;
import com.system.enums.HeroName;

public class ZhangLiao_Assault implements ISkill{

	@Override
	public void use(APlayer operator, List<ACard> cards, List<APlayer> players) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean check(APlayer operator, List<ACard> cards,
			List<APlayer> players) {
		// TODO Auto-generated method stub
		if(operator.getName() != HeroName.ZhangLiao || operator.gameStage != GameStage.drawCard)
		{
			return false;
		}
		return true;
	}
	

}
