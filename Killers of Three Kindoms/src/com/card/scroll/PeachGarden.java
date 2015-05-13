package com.card.scroll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.logic.player.APlayer;
import com.system.constants.CardConst;
import com.system.utils.PositionCompare;

//Play Phase.
//Target: All Heroes.
//Effect: All Heroes regain 1 unit of life in turn order, starting with the Hero who used this card.

public class PeachGarden extends ScrollCardAbstract {
	
	private List<APlayer> orderOfRecovering;
	PositionCompare comparePosition = new PositionCompare();

    public PeachGarden() {
        this.name = "PeachGarden";
        this.type = CardConst.CardType_Scroll_Card;
    }

    public List<APlayer> getOrderOfRecovering() {
		return orderOfRecovering;
	}

	public void use(APlayer player,List<APlayer> target)
	{
		int startPosition = player.getPosition();
		this.orderOfRecovering = new ArrayList<APlayer>();
		
		List<APlayer> subList1 = new ArrayList<APlayer>();
		List<APlayer> subList2 = new ArrayList<APlayer>();
		
		for(int i = 0; i<target.size(); i++)
		{
			if(target.get(i).getPosition() >= startPosition)
			{
				subList1.add(target.get(i));
			}
			else
			{
				subList2.add(target.get(i));
			}
		}
		
		subList1.sort(comparePosition);
		subList2.sort(comparePosition);
		
		for(int i = 0; i < subList1.size(); i++)
		{
			orderOfRecovering.add(subList1.get(i));
		}
		for(int i = 0; i < subList2.size(); i++)
		{
			orderOfRecovering.add(subList2.get(i));
		}
		
		for(APlayer targetPlayer: orderOfRecovering)
		{
			targetPlayer.gainHP(1);
		}
	}
}
