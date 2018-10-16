package com.tom.fun.rpg.core;

import java.util.List;

public abstract class Player {

	public double playerHealth = 0.0;
	
	public double playerMana = 0.0;
	
	public int playerLevel = 0;
	
	public String playerName = "";
	
	public double playerStrength = 0.0;
	
	public double playerAgility = 0.0;
	
	public double playerIntellect = 0.0;
	
	public double playerWisdom = 0.0;
	
	public double playerStamina = 0.0;
	
	public double playerCharisma = 0.0;
	
	public List<Integer> playerInventory = null;
	
	public double playerExperience = 0.0;
}
