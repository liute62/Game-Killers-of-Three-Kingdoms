package com.card.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.card.equipment.EightDiagramFormationCard;

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
