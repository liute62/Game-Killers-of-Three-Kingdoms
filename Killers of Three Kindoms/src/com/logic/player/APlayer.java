package com.logic.player;



import java.util.ArrayList;
import java.util.List;

import com.card.interfaces.ACard;
import com.logic.interfaces.IPlayer;
import com.system.constants.CardConst;
import com.system.enums.GameState;

public abstract class APlayer implements IPlayer{

	 protected int currentHP;
	 
	 public GameState gameState;
	 /****
	  * To get a list of cards which can be used in the player's turn.
	  * @param cards  the player's card
	  * @return a list of card the player can use
	  * @author liuh4
	  */
	 public List<ACard> getAvailableCards(List<ACard> cards) {
		 if(gameState == GameState.begin || gameState == gameState.check || gameState == GameState.drawCard){
			 return new ArrayList<ACard>();
		 }if(gameState == GameState.castCard){
			 List<ACard> listType = new ArrayList<ACard>();
			 for (ACard c : cards) {
					if (c != null && c.getType() == CardConst.CardType_Dodge) {
						listType.add(c);
					}
				}
			 cards.removeAll(listType);
		 }
		return cards;
	}
}
