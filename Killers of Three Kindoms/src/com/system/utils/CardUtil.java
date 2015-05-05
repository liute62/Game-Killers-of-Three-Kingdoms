package com.system.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.card.base.DodgeCard;
import com.card.base.PeachCard;
import com.card.base.StrikeCard;
import com.card.interfaces.ACard;
import com.logic.player.APlayer;
import com.logic.player.Player;


public class CardUtil {

	private static CardUtil instance;
	
	public static CardUtil getInstance() {
		if (instance == null) {
			return new CardUtil();
		}
		return instance;
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
//        Random random = new Random();
//        for (int i = 0, len = cards.size(); i < len; i++) {
//            randInts.add(random.nextInt());
//        }
		randInts = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);

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
}
