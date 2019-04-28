package edu.smith.cs.csc212.fp;

import java.util.Random;

public class Combat {

//	Take in both a player and an enemy
	public void combat(Player player, Enemy enemy) {
		 Random rand = new Random();
		 int priority_order = rand.nextInt(1);
		 if (priority_order == 0) {
			 player.priority = true;
			 }
		 else if (priority_order == 1) {
			 player.priority = false;
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
				
//				player input actions
				
//				last step, set priority to false
				player.priority = false;
			}
			
//			Enemy turn.
			else if (player.priority == false) {
				System.out.println("enemy turn");
				
//				enemy attack
				
				
				
			}
			
			
			
//			player.hp > 0 && enemy.hp > 0
			
			
			
		}
		
		
	}
	
}
