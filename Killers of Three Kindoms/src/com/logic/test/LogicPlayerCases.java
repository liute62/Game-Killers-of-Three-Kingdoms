package com.logic.test;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.PanelUI;

import org.junit.Assert;
import org.junit.Test;

import com.card.base.PeachCard;
import com.card.base.StrikeCard;
import com.card.equipment.BlackPommelCard;
import com.card.equipment.EightDiagramFormationCard;
import com.card.equipment.RedHareCard;
import com.card.equipment.ShadowRunnerCard;
import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.logic.player.Player;

public class LogicPlayerCases {

	APlayer player;
	private void initial(){
		player = new Player();
	}
	
	private List<ACard> setList(ACard...aCards){
		List<ACard> mList = new ArrayList<ACard>();
		for (int i = 0; i < aCards.length; i++) {
			mList.add(aCards[i]);
		}
		return mList;
	}
	
	@Test
	public void test1_CheckHandCards(){
		initial();
		ACard card = new PeachCard();
		ACard card2 = new StrikeCard();
		List<ACard> tmp = new ArrayList<ACard>();
		tmp.add(card);
		tmp.add(card2);
		player.setHands(tmp);
		Assert.assertEquals(player.getHands(),setList(card,card2));
	}
	
	@Test
	public void test2_CheckHP_1(){
		initial();
		player.setCurrentHP(-1);
		Assert.assertEquals(-1,player.getCurrentHP());
	}
	
	@Test
	public void test3_CheckHP_2(){
		initial();
		player.setMaxHP(5);
		player.setCurrentHP(6);
		Assert.assertEquals(5,player.getCurrentHP());
	}
	
	@Test
	public void test4_CheckHP_3(){
		initial();
		player.setMaxHP(4);
		player.setCurrentHP(3);
		player.loseHP(-1);
		Assert.assertEquals(3,player.getCurrentHP());
	}
	
	@Test
	public void test5_CheckHP_4(){
		initial();
		player.setMaxHP(4);
		player.setCurrentHP(2);
		player.gainHP(-1);
		Assert.assertEquals(2, player.getCurrentHP());
	}
	
	@Test
	public void test6_CheckEquipment_1(){
		initial();
		BlackPommelCard card = new BlackPommelCard();
		player.setWeapon(card);
		Assert.assertEquals(card,player.getWeapon());
	}
	
	@Test
	public void test7_CheckEquipment_2() {
		initial();
		EightDiagramFormationCard card = new EightDiagramFormationCard();
		player.setAmor(card);
		Assert.assertEquals(card, player.getAmor());
	}
	
	@Test
	public void test8_CheckEquipment_3(){
		initial();
		RedHareCard card = new RedHareCard();
		player.setMinusMount(card);
		Assert.assertEquals(card, player.getMinusMount());
	}
	
	@Test
	public void test9_CheckEquipment_4(){
		initial();
		ShadowRunnerCard card = new ShadowRunnerCard();
		player.setPlusMount(card);
		Assert.assertEquals(card, player.getPlusMount());
	}
	
	@Test
	public void test10_CheckDistance_1(){
		initial();
		Assert.assertEquals(1, player.getAttackRange());
	}
	
	@Test
	public void test11_CheckDistance_2(){
		initial();
		RedHareCard card = new RedHareCard();
		player.setMinusMount(card);
		Assert.assertEquals(2, player.getAttackRange());
	}
	
	@Test
	public void test12_CheckDistance_3(){
		initial();
		BlackPommelCard card = new BlackPommelCard();
		player.setWeapon(card);
		Assert.assertEquals(card.getAttackRange(),player.getAttackRange());
	}
	
	@Test
	public void test13_CheckDistance_4(){
		initial();
		RedHareCard card1 = new RedHareCard();
		player.setMinusMount(card1);
		BlackPommelCard card2 = new BlackPommelCard();
		player.setWeapon(card2);
		Assert.assertEquals(card2.getAttackRange()+1,player.getAttackRange());
	}
	
	@Test
	public void test14_CheckAttackAbility() {
		initial();
		Assert.assertEquals(1,player.getAttackAbility());
	}
}
