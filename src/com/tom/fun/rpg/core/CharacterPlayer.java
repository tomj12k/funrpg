package com.tom.fun.rpg.core;

import java.util.ArrayList;

public class CharacterPlayer extends Player {

	public static class Builder extends Player {
		
		public Builder(final String playerName) {
			super.playerName = playerName;
		}
		
		public CharacterPlayer build() {
			final CharacterPlayer playerCharacter = new CharacterPlayer();
			
			playerCharacter.playerName = super.playerName;
			
			playerCharacter.playerLevel = 1;
			
			playerCharacter.playerHealth = 10;
			playerCharacter.playerMana = 10;
			
			playerCharacter.playerStrength = 5;
			playerCharacter.playerAgility = 5;
			
			playerCharacter.playerStamina = 5;
			
			playerCharacter.playerIntellect = 5;
			playerCharacter.playerWisdom = 5;
			
			playerCharacter.playerInventory = new ArrayList<Integer>();
			
			return playerCharacter;
		}
	}
}
