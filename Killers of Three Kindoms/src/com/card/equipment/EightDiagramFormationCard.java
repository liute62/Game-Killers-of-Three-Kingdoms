package com.card.equipment;

import java.util.List;

import com.card.interfaces.IArmorCard;
import com.card.interfaces.AEquipmentCard;
import com.logic.player.APlayer;
import com.system.enums.CardColors;



/**
 * This is a kind of equipment 
 * function:
 * 
 * @author liuh4
 *
 */
public class EightDiagramFormationCard extends AEquipmentCard implements IArmorCard{

	
	//check for a card and to see wheater is 
	public boolean check(String colors){
	
		if(colors.equals("Heart") || colors.equals("Diamond")){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Check a random card, if its color is heart or diamond
	 * 
	 */
	@Override
	public void use(APlayer player, List<APlayer> target) {
		// TODO Auto-generated method stub
		
	}
}

