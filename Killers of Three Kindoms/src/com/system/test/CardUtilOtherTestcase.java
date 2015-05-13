package com.system.test;

import com.card.interfaces.ACard;
import com.system.utils.CardUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CardUtilOtherTestcase {
    private void printCards(List<ACard> cards) {
        for (int i = 0, len = cards.size(); i < len; i++) {
            System.out.print(cards.get(i).getName() + ", ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    @Test
    public void testAllCardsGenerated() {
        CardUtil cardUtil = CardUtil.getInstance();
        List<ACard> cards = cardUtil.generateInitialCardDeck();
        assertEquals(53, cards.size());
        printCards(cards);
    }

    @Test
    public void testAllCardsGeneratedAndShuffled() {
        CardUtil cardUtil = CardUtil.getInstance();
        List<ACard> cards = cardUtil.generateInitialCardDeck();
        cardUtil.shuffleCard(cards);
        assertEquals(53, cards.size());
        printCards(cards);
    }
}
