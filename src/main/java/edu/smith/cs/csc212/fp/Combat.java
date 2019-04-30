package edu.smith.cs.csc212.fp;

import java.util.Random;
import java.util.Scanner;

public class Combat {

//	Take in both a player and an enemy
	public static void combat(Player player, Enemy enemy) {
		 Random rand = new Random();
		 int priority_order = rand.nextInt(1);
		 if (priority_order == 0) {
			 System.out.println("priority_order result: " + priority_order + " Should be 0");
			 player.priority = true;
			 System.out.println("Player priority: " + player.priority + " Should be true");
			 }
		 else if (priority_order == 1) {
			 System.out.println("priority_order result: " + priority_order + " Should be 1");
			 player.priority = false;
			 System.out.println("Player priority: " + player.priority + " Should be false");
			 }
		
	

		Boolean combatants_engaged = true;
		Boolean run = false;
//		While player and enemy are alive and the player has not ran away.
		while (combatants_engaged == true) {
			
//			3 cases, player wins and gets reward, leave combat.
//			player dies, leave combat and game ends.
//			player runs, leave combat, no loot.
			if (player.hp <= 0 || enemy.hp <= 0 || run == true) {
				combatants_engaged = false;
			}

//			Player turn.
			if (player.priority == true) {
				System.out.println("player turn");
				String input = "";
				
				  while (!input.equals("attack") || !input.equals("inventory") || !input.equals("player") || !input.equals("run")) {
					  Scanner scanner = new Scanner(System.in);
					  input = scanner.next();
//					  Move to character creation.
					  if (input.equals("attack")) {
						  continue;
						  
					  }
					  else if (input.equals("inventory")) {
						  continue;
						  
					  }
					  else if (input.equals("player")) {
						  continue;
						  
					  }
					  else if (input.equals("run")) {
						  continue;
						  
					  }
					  else {
						  continue;
					  }
					  }
				
				
				
//				player input actions
				
//				last step, set priority to false
				player.priority = false;
				continue;
			}
			
//			Enemy turn.
			else if (player.priority == false) {
				System.out.println("enemy turn");
				player.priority = true;
				continue;
				
//				enemy attack	
			}
//			player.hp > 0 && enemy.hp > 0
			
			
			
		}
	}
	
}
