package com.card.equipment;

import java.util.List;

import com.card.interfaces.AEquipmentCard;
import com.card.interfaces.IWeaponCard;
import com.card.interfaces.WeaponCard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;


public class BlackPommelCard extends WeaponCard implements IWeaponCard{

	public BlackPommelCard() {
		// TODO Auto-generated constructor stub
		this.name = "BlackPommel";
		this.type = CardConst.CardType_Weapon;
		this.attackRange = 2;
	}
	
	@Override
	public void checkArmor() {
		// TODO Auto-generated method stub
		
	}

	

	
}

