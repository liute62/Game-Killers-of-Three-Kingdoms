package com.logic.test;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.card.base.PeachCard;
import com.card.base.StrikeCard;
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
	
}
