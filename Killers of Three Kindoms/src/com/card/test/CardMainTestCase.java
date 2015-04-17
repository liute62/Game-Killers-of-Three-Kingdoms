package com.card.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.card.base.PeachCard;
import com.card.equipment.EightDiagramFormationCard;
import com.logic.player.Player;

public class CardMainTestCase {

	@Test
	public void testForEightDiagramFormationCard() {
		EightDiagramFormationCard card = new EightDiagramFormationCard();
		assertEquals(true,card.check("Heart"));
		assertEquals(true,card.check("Diamond"));
		assertEquals(false,card.check("Club"));
		assertEquals(false,card.check("Spade"));
	}

}
