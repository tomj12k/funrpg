package com.tom.fun.rpg.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Runner {
	final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		mainMenu();
	}

	public static void printer(final String input) {
		System.out.println(input);
	}
	
	public static String stringScanner() {
		final String returnString = scan.next();

		return returnString;
	}
	
	public static void mainMenu() {
		printer("Welcome to the FunRPG!");
		printer("");
		printer("Please enter your name:");
		final String playerName = stringScanner();
		final CharacterPlayer player = new CharacterPlayer
				.Builder(playerName).build();
		
		printer("Thank you " + player.playerName);
		printer("Entering World!");
		
		gameWorld(player);
	}
	
	public static void gameWorld(final CharacterPlayer player) {
		printer("World");
		String gameActions = "";
		
		final EnemyCharacter enemy = new EnemyCharacter
				.Builder("BadGuy")
				.build();
		
		printer("An enemy approaches; it's name is: " 
		+ enemy.playerName);
		boolean battleEnd = false;
		
		while(!battleEnd) {
			if (gameActions.equals("endGame")) {
				break;
			}
			
			if (gameActions.equals("a")) {
				printer("You attack the enemy!");
				final Iterator<Entry<Player, Boolean>> victorIterator = 
						battleVictory(player, enemy).entrySet().iterator();
				while (victorIterator.hasNext()) {
					final Entry<Player, Boolean> victor = victorIterator.next();
				
					if (victor.getValue() == true) {
						printer(victor.getKey().playerName + " is the victor!");
						battleEnd = true;
					}
				}
				// deal damage
				final double damageDealt = damageCalculator(player, enemy);
				printer("for " + damageDealt + " damage.");
			}
			printer("You are battling!");
			printer("Your Health is " + player.playerHealth);
			printer("The enemy Health is " + enemy.playerHealth);
			gameActions = stringScanner();
		}
		
		printer("Congratulations on winning the battle!");
		scan.close();
	}
	
	public static double damageCalculator(final CharacterPlayer player, 
			final EnemyCharacter enemy) {
		double damageDealtToEnemy = 0.0;
		damageDealtToEnemy = Math.random();
		enemy.playerHealth = enemy.playerHealth - damageDealtToEnemy;

		return damageDealtToEnemy;
	}
	
	// This is such a waste... why a map?
	public static Map<Player, Boolean> battleVictory(final CharacterPlayer player, 
			final EnemyCharacter enemy) {
		final Map<Player, Boolean> playerVictorMap = new HashMap<Player, Boolean>();
		boolean isEnemyVictor = false;
		boolean isPlayerVictor = false;
		
		if (player.playerHealth >= 0.0 && enemy.playerHealth <= 0.0) {
			isPlayerVictor = true;
			playerVictorMap.put(player, isPlayerVictor);
		} else if (player.playerHealth <= 0.0 && enemy.playerHealth >= 0.0) {
			isEnemyVictor = true;
			playerVictorMap.put(enemy, isEnemyVictor);
		}
		
		return playerVictorMap;
	}
}
