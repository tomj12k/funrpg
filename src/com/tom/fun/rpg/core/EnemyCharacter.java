package com.tom.fun.rpg.core;

import java.util.ArrayList;

public class EnemyCharacter extends Player {

	public static class Builder extends Player {
		
		public Builder(final String playerName) {
			super.playerName = playerName;
		}
		
		public EnemyCharacter build() {
			final EnemyCharacter enemyCharacter = new EnemyCharacter();
			
			enemyCharacter.playerName = super.playerName;
			
			enemyCharacter.playerLevel = 1;
			
			enemyCharacter.playerHealth = 10;
			enemyCharacter.playerMana = 10;
			
			enemyCharacter.playerStrength = 5;
			enemyCharacter.playerAgility = 5;
			
			enemyCharacter.playerStamina = 5;
			
			enemyCharacter.playerIntellect = 5;
			enemyCharacter.playerWisdom = 5;
			
			enemyCharacter.playerInventory = new ArrayList<Integer>();
			
			return enemyCharacter;
		}
	}
}
