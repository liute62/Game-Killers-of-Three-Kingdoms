package com.card.equipment;

import java.util.List;

import com.card.interfaces.AmorCard;
import com.card.interfaces.IArmorCard;
import com.card.interfaces.AEquipmentCard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.constants.SuitConst;
import com.system.utils.ResUtil;


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
        this.profile = ResUtil.getImgByName("armor_eightdiagramformation", 1);
    }
	
	//check for a card and to see whether is 
	public boolean check(int colors){
		if(colors == SuitConst.SuitType_Hearts || colors == SuitConst.SuitType_Diamonds){
			return true;
		}else {
			return false;
		}
	}
	
	 @Override
	 public void use(APlayer player, List<APlayer> target) {
	    	// TODO Auto-generated method stub
	    	super.use(player, target);
	    	player.getDeckEquipmentPanel().setAEquipment(this);
	 }

}

