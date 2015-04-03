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
	 *  2. For each 0 <= n <= cards.size(), switch the nth and (n+1)th position
	 *  3. return the list
	 *
	 * @param cards a list of cards except some card still in the battlefield
	 * @return a list of cards which items randomly set.
	 * @author Jackie
	 */
	public List<ACard> shuffleCard(List<ACard> cards) {
        // Generate a list of integers
        Random random = new Random();
        List<Integer> randInts = new ArrayList<Integer>();
        for (int i = 0, len = cards.size(); i < len; i++) {
            randInts.add(random.nextInt());
        }
        return cards;
	}
}
