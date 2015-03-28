package com.card.equipment;

import com.card.interfaces.ArmorCardAbstract;
import com.card.interfaces.EquipmentCardInterface;
import com.system.enums.CardColors;



/**
 * This is a kind of equipment 
 * function:
 * 
 * @author liuh4
 *
 */
public class EightDiagramFormationCard extends ArmorCardAbstract implements EquipmentCardInterface{


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
