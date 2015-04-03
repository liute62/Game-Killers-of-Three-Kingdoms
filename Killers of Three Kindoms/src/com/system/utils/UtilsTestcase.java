package com.system.utils;

import com.card.interfaces.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilsTestcase {

    private class TestCard extends ACard {
        @Override
        public void use() {
            throw new UnsupportedOperationException();
        }
    }

    private List<Integer> inputInts;
    private List<Integer> expectedInts;
    private CardUtil cardUtil;

    private static List<Integer> list(Integer...integers) {
        return Arrays.asList(integers);
    }

    private ACard makeCard(int id) {
        TestCard testCard = new TestCard();
        testCard.setId(id);
        return testCard;
    }
    private List<ACard> makeCards(List<Integer> integers) {
        List<ACard> cards = new ArrayList<ACard>();
        for (int i = 0; i < integers.size(); i++) {
            cards.add(makeCard(integers.get(i)));
        }
        return cards;
    }

    public UtilsTestcase(List<Integer> inputInts, List<Integer> expectedInts) {
        this.inputInts = inputInts;
        this.expectedInts = expectedInts;
    }

    @Before
    public void initializeCardUtil() {
        this.cardUtil = new CardUtil();
    }

    @Parameterized.Parameters
    public static Collection inputCardsList() {
        return Arrays.asList(new Object[][] {
                {list(), list()},
                {list(1), list(1)},
                {list(1, 2), list(2, 1)},
                {list(1, 2, 3), list(3, 2, 1)}
        });
    }

    @Test
    public void testShuffleCard() {
        System.out.println("Testing cards: " + inputInts);
        List<ACard> inputCards = makeCards(inputInts);
        List<ACard> expectedCards = makeCards(expectedInts);
        List<ACard> resultCards = this.cardUtil.shuffleCard(inputCards);

        assertEquals(resultCards.size(), expectedCards.size());
        for (int i = 0, len = expectedCards.size(); i < len; i++) {
            assertEquals(expectedCards.get(i).getId(), resultCards.get(i).getId());
        }
    }
}
