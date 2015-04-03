package com.system.utils;

import com.card.interfaces.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilsTestcase {

    private class TestCard extends ACard {
        @Override
        public void use() {
            throw new UnsupportedOperationException();
        }
    }

    private List<ACard> inputCards;
    private List<ACard> expectedCards;

    private ACard makeCard(int id) {
        TestCard testCard = new TestCard();
        testCard.setId(id);
        return testCard;
    }
    private List<ACard> makeCards(Integer...integers) {
        List<ACard> cards = new ArrayList<ACard>();
        for (int i = 0; i < integers.length; i++) {
            cards.add(makeCard(integers[i]));
        }
        return cards;
    }

    public UtilsTestcase(List<ACard> inputCards, List<ACard> expectedCards) {
        this.inputCards = inputCards;
        this.expectedCards = expectedCards;
    }

    @Parameterized.Parameters
    public Collection inputCardsList() {
        return Arrays.asList(new Object[][] {
                {}
        });
    }

    @Test
    public void testShuffleCard() {
        
    }
}
