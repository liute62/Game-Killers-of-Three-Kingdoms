package com.system.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.card.interfaces.ACard;


public class CardUtil {

	private static CardUtil instance;
	
	
	public static CardUtil getInstance(){
		if(instance == null){
			instance = new CardUtil();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return a list of cards which attribute read from file.
	 * @author Xiangtian
	 */
	public List<ACard> initialCards(){ 
		return null;
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
//        List<Integer> randInts = new ArrayList<Integer>();
//        Random random = new Random();
//        for (int i = 0, len = cards.size(); i < len; i++) {
//            randInts.add(random.nextInt());
//        }
//        randInts = Arrays.asList(new Integer[]{1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31});
		if (cards.size() > 1) {
			ACard temp = cards.get(0);
			cards.set(0, cards.get(1));
			cards.set(1, temp);
		}
		return cards;
	}
}
