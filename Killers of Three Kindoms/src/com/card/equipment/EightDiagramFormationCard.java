package com.card.equipment;

import java.util.List;

import com.card.interfaces.AmorCard;
import com.card.interfaces.IArmorCard;
import com.card.interfaces.AEquipmentCard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;



/**
 * This is a kind of equipment 
 * function:
 * 
 * @author liuh4
 *
 */
public class EightDiagramFormationCard extends AmorCard implements IArmorCard{

	public EightDiagramFormationCard(){
		this.name = "EightDiagramFormation";
		this.type = CardConst.CardType_Armor;
	}
	
	//check for a card and to see whether is 
	public boolean check(String colors){
	
		if(colors.equals("Heart") || colors.equals("Diamond")){
			return true;
		}else {
			return false;
		}
	}

}

