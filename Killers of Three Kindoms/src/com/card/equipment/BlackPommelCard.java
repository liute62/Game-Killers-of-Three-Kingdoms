package com.card.equipment;

import java.util.List;

import com.card.interfaces.AEquipmentCard;
import com.card.interfaces.IWeaponCard;
import com.card.interfaces.WeaponCard;
import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.DebugUtil;
import com.system.utils.ResUtil;


public class BlackPommelCard extends WeaponCard implements IWeaponCard{

	public BlackPommelCard() {
		// TODO Auto-generated constructor stub
		this.name = "BlackPommel";
		this.type = CardConst.CardType_Weapon;
        this.profile = ResUtil.getImgByName("weapon_blackpommel", 1);
        this.attackRange = 2;
    }
	
	@Override
	public void checkArmor() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void use(APlayer player, List<APlayer> target) {
		// TODO Auto-generated method stub
		super.use(player, target);
		DebugUtil.print();
		player.getDeckEquipmentPanel().setAEquipment(this);
	}	
}

