package com.system.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.card.base.DodgeCard;
import com.card.base.PeachCard;
import com.card.base.StrikeCard;
import com.card.equipment.*;
import com.card.interfaces.ACard;
import com.card.scroll.PeachGarden;
import com.gui.gaming.CardPanel;
import com.logic.player.APlayer;
import com.logic.player.Player;
import com.system.constants.CardConst;
import com.system.constants.SuitConst;


public class CardUtil {

	private static CardUtil instance;
	private List<CardPanel> playerHandCardPanels;
	
	public static CardUtil getInstance() {
		if (instance == null) {
			return new CardUtil();
		}
		return instance;
	}
	
	private CardUtil(){
		instance = this;
	}
	
	public List<ACard> getInitialCards(APlayer player){
		List<ACard> cards = new ArrayList<ACard>();
		cards.add(new PeachCard());
		cards.add(new StrikeCard());
		cards.add(new PeachCard());
		cards.add(new DodgeCard());
		return cards;
	}
	/**
	 * Shuffle the card after game reset.
	 * Shuffle uses the following algorithm:
	 *  1. Generate a list of integers
	 *  2. For each 0 < n < cards.size()
	 *      switch the (2n-2)th and (2n-1)th position (wrap around if out of index)
	 *  3. return the list
	 *
	 * @param cards a list of cards except some card still in the battlefield
	 * @return a list of cards which items randomly set.
	 * @author Jackie
	 */
	public List<ACard> shuffleCard(List<ACard> cards) {
		// Generate a list of integers.
		List<Integer> randInts = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0, len = cards.size(); i < len; i++) {
            int t = random.nextInt();
            while (t <= 0) {
                t = random.nextInt();
            }
            randInts.add(t);
        }
//		randInts = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

        // Shuffle cards.
		for (int n = 1; n < cards.size(); n++) {
            int pos0 = randInts.get((2 * n - 2) % randInts.size()) % cards.size();
            int pos1 = randInts.get((2 * n - 1) % randInts.size()) % cards.size();
            ACard temp = cards.get(pos0);
			cards.set(pos0, cards.get(pos1));
			cards.set(pos1, temp);
		}
		return cards;
	}

    /**
     * Generates the initial card deck.
     * @return the generated deck.
     */
    public List<ACard> generateInitialCardDeck() {
        ArrayList<ACard> cardList = new ArrayList<>();
        int[] id = new int[1];
        id[0] = 0;

        // Hearts Dodge * 4
        addCardToList(cardList, 4, DodgeCard.class, id, SuitConst.SuitType_Hearts, CardConst.CardType_Dodge);
        // Diamonds Dodge * 8
        addCardToList(cardList, 8, DodgeCard.class, id, SuitConst.SuitType_Diamonds, CardConst.CardType_Dodge);
        // Hearts Peach * 6
        addCardToList(cardList, 6, PeachCard.class, id, SuitConst.SuitType_Hearts, CardConst.CardType_Peach);
        // Spades Strike * 7
        addCardToList(cardList, 7, StrikeCard.class, id, SuitConst.SuitType_Spades, CardConst.CardType_Strike);
        // Hearts Strike * 2
        addCardToList(cardList, 2, StrikeCard.class, id, SuitConst.SuitType_Hearts, CardConst.CardType_Strike);
        // Clubs Strike * 14
        addCardToList(cardList, 14, StrikeCard.class, id, SuitConst.SuitType_Clubs, CardConst.CardType_Strike);
        // Diamonds Strike * 6
        addCardToList(cardList, 6, StrikeCard.class, id, SuitConst.SuitType_Diamonds, CardConst.CardType_Strike);
        // Clubs BlackPommel * 1
        addCardToList(cardList, 1, BlackPommelCard.class, id, SuitConst.SuitType_Clubs, CardConst.CardType_Weapon);
        // Clubs EightDiagramFormation * 1
        addCardToList(cardList, 1, EightDiagramFormationCard.class, id,
                SuitConst.SuitType_Clubs, CardConst.CardType_Armor);
        // Hearts QilinBow * 1
        addCardToList(cardList, 1, QilinBowCard.class, id, SuitConst.SuitType_Hearts, CardConst.CardType_Weapon);
        // Hearts RedHare * 1
        addCardToList(cardList, 1, RedHareCard.class, id, SuitConst.SuitType_Hearts, CardConst.CardType_Mount_Minus);
        // Spades ShadowRunner * 1
        addCardToList(cardList, 1, ShadowRunnerCard.class, id, SuitConst.SuitType_Spades, CardConst.CardType_Mount_Plus);
        // Hearts PeachGarden * 1
        addCardToList(cardList, 1, PeachGarden.class, id, SuitConst.SuitType_Hearts, CardConst.CardType_Scroll_Card);
        return cardList;
    }
    private void addCardToList(
            List<ACard> list, int count, Class<? extends ACard> cardClass, int[] id, int suit, int type) {
        for (int i = 0; i < count; i++) {
            try {
                ACard card = cardClass.newInstance();
                card.setId(id[0]);
                card.setSuit(suit);
                card.setType(type);
                list.add(card);
                id[0]++;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

	public List<CardPanel> getPlayerHandCardPanels() {
		return playerHandCardPanels;
	}

	public void setPlayerHandCardPanels(List<CardPanel> playerHandCardPanels) {
		this.playerHandCardPanels = playerHandCardPanels;
	}
}
