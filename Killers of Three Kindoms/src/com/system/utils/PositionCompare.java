package com.system.utils;

import java.util.Comparator;

import com.logic.player.APlayer;

public class PositionCompare implements Comparator<APlayer>
	{

		@Override
		public int compare(APlayer p1, APlayer p2) {
			// TODO Auto-generated method stub
			if(p1.getPosition() < p1.getPosition())
			{
				return 0;
			}
			return 1;
		}
		
	}
