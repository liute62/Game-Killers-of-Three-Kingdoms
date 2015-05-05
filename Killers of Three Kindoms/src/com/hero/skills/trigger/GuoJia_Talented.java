package com.hero.skills.trigger;

import java.util.List;

import com.card.interfaces.ACard;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;
import com.system.enums.GameStage;

public class GuoJia_Talented implements ISkill{
	
	public void talented(APlayer player, ACard card)
	{
		player.getHands().add(card);
	}

	@Override
	public void use(APlayer operator, List<ACard> cards, List<APlayer> players) {
		for(ACard card: cards)
		{
			talented(operator, card);
		}
	}

	@Override
	public boolean check(APlayer operator, List<ACard> cards,
			List<APlayer> players) {
		if(operator.gameStage == GameStage.check && cards.get(0) != null)
		{
			return true;
		}
		return false;
	}
}
