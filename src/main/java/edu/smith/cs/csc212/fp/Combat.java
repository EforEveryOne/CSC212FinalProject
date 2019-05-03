package edu.smith.cs.csc212.fp;

import java.util.Random;
import java.util.Scanner;

public class Combat {

//	Take in both a player and an enemy
	public static void combat(Player player, Enemy enemy) {
		Random rand = new Random();
		int priority_order = rand.nextInt(2);
//		System.out.println("Priority order roll: " + priority_order);
		if (priority_order == 0) {
			player.priority = true;
			System.out.println(player.name + " is able to act before the " + enemy.name + ". ");
			}
		else if (priority_order == 1) {
			player.priority = false;
			System.out.println("The " + enemy.name + " is able to act before " + player.name + ". ");
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
			while (player.priority == true && player.hp > 0 && enemy.hp > 0) {
				System.out.println("player turn: ");
				String input = "";
				
				  if (!input.equals("attack") || !input.equals("inventory") || !input.equals("player") || !input.equals("run")) {
					  Scanner scanner = new Scanner(System.in);
					  input = scanner.next();

//					Specific input
					  if (input.equals("attack")) {
						  System.out.println(player.name + " attacks for: " + player.damage_value);
						  enemy.hp -= (player.damage_value - Enemy.defense_value);
						  System.out.println("Enemy hp: " + enemy.hp + "/" + Enemy.max_hp + " Enemy defense: " + Enemy.defense_value + " Enemy damage: " + Enemy.damage_value );
						  player.priority = false;
//						  System.out.println("player.priority: Should be FALSE:" +  player.priority);
						  continue;
						  }
					  else if (input.equals("inventory")) {
						  System.out.println("TODO: inventory. ");
//						  Will be used for un/equipping items, or consumables.
						  continue;
						  }
					  else if (input.equals("player")) {
						  System.out.println(player.print_details(player));
						  continue;
						  }
					  else if (input.equals("run")) {
//						  This is one of the cases handled.
						  System.out.println("You run away! ");
						  run = true;
						  combatants_engaged = false;
						  player.priority = false;
						  break;
						  }
					  else {
						  System.out.println("\nOptions: [attack], [player], [run], TODO:[inventory] ");
						  continue;
						  }
					  }
//				last step, set priority to false
				player.priority = false;
				continue;
				}
			
//			Enemy turn.
			if (player.priority == false && run == false && enemy.hp > 0) {
				System.out.println("\nEnemy turn: ");
				System.out.println("The " + enemy.name + " attacked you for " + Enemy.damage_value + "! ");
				player.hp -= Enemy.damage_value - player.defense_value;
				System.out.println(player.name + " HP: " + player.hp + "/" + player.max_hp + ".\n ");
				player.priority = true;
				continue;
				}
			}
//		Once combatants are no longer engaged, we check the result for each case.
		if (combatants_engaged == false && run == false && player.hp > 0) {
//			reward happens!
			System.out.println("\n\n\n" + player.name +" defeated the " + enemy.name + "! ");
			player.kill_count += 1;
			player.current_exp += enemy.exp_reward;
			player.currency += enemy.currency_reward;
			System.out.println(player.name + " found: " + enemy.currency_reward + " gold. ");
			System.out.println(player.name + " gained: " + enemy.exp_reward + " experience. ");
			
			
//			Finally check if the player leveled.
			player.level_up_check(player);
			}
		else if (combatants_engaged == false && run == false && player.hp <= 0) {
			System.out.println("You're dead! :( ");
//			END THE GAME.
			}
		}
	}
