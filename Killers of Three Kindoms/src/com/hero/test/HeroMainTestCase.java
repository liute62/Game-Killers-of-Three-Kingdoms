package com.hero.test;

import static org.junit.Assert.*;

import com.card.base.DodgeCard;
import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.hero.skills.active.GuanYu_MasterOfWarfare;
import com.hero.skills.interfaces.ISkill;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.constants.SuitConst;
import com.system.enums.HeroName;
import org.junit.Test;

import java.util.Arrays;

public class HeroMainTestCase {

	@Test
	public void testOtherCanNotUseGuanYuSSkill() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        ISkill skill = new GuanYu_MasterOfWarfare();
        ACard strikeCard = new StrikeCard();
        strikeCard.setSuit(SuitConst.SuitType_Hearts);
        player.setName(HeroName.ZhaoYun);
        player.setSkill(skill);
        assertEquals(false, player.checkSkill(Arrays.asList(strikeCard), Arrays.asList(player1)));
	}

    @Test
    public void testGuanYuCanUseHisSkill() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        ISkill skill = new GuanYu_MasterOfWarfare();
        ACard dodgeCard = new DodgeCard();
        dodgeCard.setSuit(SuitConst.SuitType_Hearts);
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(true, player.checkSkill(Arrays.asList(dodgeCard), Arrays.asList(player1)));
    }

}
