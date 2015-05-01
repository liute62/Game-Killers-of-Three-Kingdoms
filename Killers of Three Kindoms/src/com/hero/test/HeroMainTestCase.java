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

import java.util.ArrayList;
import java.util.Arrays;

public class HeroMainTestCase {

	@Test
	public void testOtherCanNotUseGuanYuSSkill() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
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
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(2);
        ISkill skill = new GuanYu_MasterOfWarfare();
        ACard dodgeCard = new DodgeCard();
        dodgeCard.setSuit(SuitConst.SuitType_Hearts);
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(true, player.checkSkill(Arrays.asList(dodgeCard), Arrays.asList(player1)));
    }

    @Test
    public void testGuanYuCanNotUseBlackCardToActivateSkill() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
        ISkill skill = new GuanYu_MasterOfWarfare();
        ACard dodgeCard = new DodgeCard();
        dodgeCard.setSuit(SuitConst.SuitType_Spades);
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(false, player.checkSkill(Arrays.asList(dodgeCard), Arrays.asList(player1)));
    }

    @Test
    public void testGuanYuCanNotUseBlackCardToActivateSkillTwo() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
        ISkill skill = new GuanYu_MasterOfWarfare();
        ACard dodgeCard = new DodgeCard();
        dodgeCard.setSuit(SuitConst.SuitType_Clubs);
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(false, player.checkSkill(Arrays.asList(dodgeCard), Arrays.asList(player1)));
    }

    @Test
    public void testGuanYuCanNotUseNoCardsToActivateSkill() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
        ISkill skill = new GuanYu_MasterOfWarfare();
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(false, player.checkSkill(new ArrayList<ACard>(), Arrays.asList(player1)));
    }

    @Test
    public void testGuanYuCanNotTargetNoOneToActivateSkill() {
        APlayer player = new Player();
        ISkill skill = new GuanYu_MasterOfWarfare();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        ACard dodgeCard = new DodgeCard();
        dodgeCard.setSuit(SuitConst.SuitType_Hearts);
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(false, player.checkSkill(Arrays.asList(dodgeCard), new ArrayList<APlayer>()));
    }

    @Test
    public void testGuanYuCanNotUseMoreThanOneCardsToActivateSkill() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
        ISkill skill = new GuanYu_MasterOfWarfare();
        ACard dodgeCard = new DodgeCard();
        dodgeCard.setSuit(SuitConst.SuitType_Hearts);
        ACard strikeCard = new StrikeCard();
        strikeCard.setSuit(SuitConst.SuitType_Hearts);
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(false, player.checkSkill(Arrays.asList(dodgeCard, strikeCard), Arrays.asList(player1)));
    }

    @Test
    public void testGuanYuCanNotTargetOutOfRangePlayerToActivateSkill() {
        APlayer player = new Player();
        APlayer player1 = new Player();
        player.setCurrentHP(5);
        player.setAttackRange(1);
        player.setPosition(1);
        player1.setCurrentHP(5);
        player1.setPosition(3);
        ISkill skill = new GuanYu_MasterOfWarfare();
        ACard dodgeCard = new DodgeCard();
        dodgeCard.setSuit(SuitConst.SuitType_Hearts);
        player.setName(HeroName.GuanYu);
        player.setSkill(skill);
        assertEquals(false, player.checkSkill(Arrays.asList(dodgeCard), Arrays.asList(player1)));
    }

}
