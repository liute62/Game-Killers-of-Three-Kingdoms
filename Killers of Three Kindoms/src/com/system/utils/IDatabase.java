package com.system.utils;

import com.system.enums.HeroName;

public interface IDatabase {

	public abstract int getMaxHP(HeroName name);

	public abstract String getSkillName(HeroName heroName);
	
	
	
	
}
