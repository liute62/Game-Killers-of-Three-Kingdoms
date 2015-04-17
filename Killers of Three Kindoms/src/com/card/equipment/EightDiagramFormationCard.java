package com.card.equipment;

import com.card.interfaces.IArmorCard;
import com.card.interfaces.AEquipmentCard;
import com.system.enums.CardColors;



/**
 * This is a kind of equipment 
 * function:
 * 
 * @author liuh4
 *
 */
public class EightDiagramFormationCard extends AEquipmentCard implements IArmorCard{


	@Override
	public void use() {
		// TODO Auto-generated method stub
	}
	
	//check for a card and to see wheater is 
	public boolean check(String colors){
	
		if(colors.equals("Heart") || colors.equals("Diamond")){
			return true;
		}else {
			return false;
		}
	}
}
