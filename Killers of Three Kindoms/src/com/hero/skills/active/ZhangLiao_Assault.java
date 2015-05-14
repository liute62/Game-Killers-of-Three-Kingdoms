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
		Random random = new Random();
		for(APlayer player: players)
		{
			if(player.getHands().size() == 1)
			{
				operator.getHands().add(player.getHands().get(0));
			}
			else 
			{
				int min = 0;
				int max = player.getHands().size()-1;
				int randomIndex = random.nextInt(max)%(max-min+1) + min;
				operator.getHands().add(player.getHands().get(randomIndex));
			}
			
		}
	}

	@Override
	public boolean check(APlayer operator, List<ACard> cards,
			List<APlayer> players) {
		// TODO Auto-generated method stub
		if(operator.getName() != HeroName.ZhangLiao || operator.gameStage != GameStage.drawCard)
		{
			return false;
		}
		else {
			for(APlayer player: players)
			{
				if(player.getHands() == null) return false;
			}
		}
		return true;
	}
	

}
