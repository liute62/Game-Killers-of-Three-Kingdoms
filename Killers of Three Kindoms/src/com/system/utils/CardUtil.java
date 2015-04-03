package com.system.utils;

import java.util.List;

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
	 * @param cards a list of cards except some card still in the battlefield
	 * @return a list of cards which items randomly set. (which is definitely different from the input)
	 * @author jakie
	 */
	public List<ACard> shuffleCard(List<ACard> cards){
		return null;
	}
}
