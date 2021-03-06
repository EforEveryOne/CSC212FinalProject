package edu.smith.cs.csc212.fp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
	
	
	
//	personal stuff
	String name;
	int age;
	int hp;
	int max_hp;
// 	stats
	int stat_points;
	int endurance;
	int strength;
	int defense_value;
	int damage_value;
//	level
	int level;
	int current_exp;
	int next_level_exp;
	int currency;
	boolean priority;
	int kill_count;
	static ArrayList<Item> inventory;

	/**
	 * @param hp - current hitpoint value. If it goes to 0 or lower the player is dead!
	 * @param name - player name.
	 * @param age - flavor text.
	 * @param max_hp - max value for hitpoints.
	 * @param stat_points - points that can be spent to increase strength or endurance.
	 * @param endurance - a player stat used to increase player hitpoints.
	 * @param strength - a player stat used to increase player damage.
	 * @param defense_value - combined total of player armor.
	 * @param damage_value - combined total of player damage.
	 * @param level - player current level.
	 * @param current_exp - player current experience value.
	 * @param next_level_exp - the target value they need their current_exp to reach in order to level up.
	 * @param currency - how much money the player has.
	 * @param priority - determines if it's the player or enemy turn.
	 * @param kill_count - shows how many enemies the player has defeated at the end of the game (when they die).
	 * @param inventory - player inventory.
	 */
	public Player(String name,
			int hp,
			int age,
			int max_hp,
			int stat_points,
			int endurance,
			int strength, 
			int defense_value, 
			int damage_value,
			int level,
			int current_exp,
			int next_level_exp,
			int currency,
			boolean priority,
			int kill_count,
			ArrayList<Item> inventory) {
		this.name = name;
		this.age = age;
		this.hp = hp;
		this.max_hp = max_hp;
		this.stat_points = stat_points;
		this.endurance = endurance;
		this.strength = strength;
		this.defense_value = defense_value;
		this.damage_value = damage_value;
		this.level = level;
		this.current_exp = current_exp;
		this.next_level_exp = next_level_exp;
		this.currency = currency;
		this.priority = priority;
		this.kill_count = kill_count;
		Player.inventory = inventory;
		}
	
	public void offer_spend_points(Player player) {
		String input = "";
		while (!input.equals("yes") || !input.equals("no")) {
			System.out.println("Do you want to spend attribute points?\n [yes] or [no] ");
			Scanner scanner = new Scanner(System.in);
			input = scanner.next();
			
			if (input.equals("yes")) {
				spend_points(player);
				break;
			}
			else if (input.equals("no")) {
				break;
			}
			else {
				System.out.println("Please type a valid input.\n ");
				continue;
				}
			}	
		}
//	These points can be spent to increase strength or endurance.
	public void spend_points(Player player) {
		System.out.println("______________________");
		System.out.println("|SPENDING STAT POINTS|");
		System.out.println("Endurance: " + player.endurance + ". ");
		System.out.println("Strength: " + player.strength + ". ");
		System.out.println("\nUnspent points: " + player.stat_points + ". ");
		
//		Valid amount of points.
		if (player.stat_points > 0) {
			String input = "";
			int spendInput = 0;

			while (!input.equals("endurance") || !input.equals("strength") || !input.equals("cancel")) {
				System.out.println("Options: [endurance] or [strength] or [cancel] ");
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				
				if (input.equals("endurance")) {
					System.out.println("\nIncrease endurance by: ");
					while (spendInput <= 0 && !scanner.hasNextInt() ){
						scanner.next();
						System.out.println("Please type a valid number. ");
						}
					spendInput = scanner.nextInt();
//					if there is a valid amount of points entered
					if (spendInput <= player.stat_points) {
						System.out.println("player endurance before increase: " + player.endurance);
						System.out.println("player stat_points before increase: " + player.stat_points);
						System.out.println("spendInput current value: " + spendInput);
						player.endurance += spendInput;
						player.stat_points -= spendInput;

						System.out.println("player endurance after increase: " + player.endurance);
						System.out.println("player stat_points after increase: " + player.stat_points);
//						Compute the stats (increase max hp, etc.)
						calculate_stats(player);
						break;
						}
//						if they want to spend more points than they have available.
					else if (spendInput > player.stat_points) {
						System.out.println("You don't have " + spendInput + " points available to spend. ");
						System.out.println("Current available points: " + player.stat_points + ".\n ");
						}
					}
				else if (input.equals("strength")) {
					System.out.println("\nIncrease strength by: ");
					while (spendInput <= 0 && !scanner.hasNextInt() ){
						scanner.next();
						System.out.println("Please type a valid number. ");
						}
					spendInput = scanner.nextInt();
//					if there is a valid amount of points entered
					if (spendInput <= player.stat_points) {
						System.out.println("player strength before increase: " + player.strength);
						System.out.println("player stat_points before increase: " + player.stat_points);
						System.out.println("spendInput current value: " + spendInput);
						player.strength += spendInput;
						player.stat_points -= spendInput;

						System.out.println("player strength after increase: " + player.strength);
						System.out.println("player stat_points after increase: " + player.stat_points);
//						Compute the stats (increase max hp, etc.)
						calculate_stats(player);
						break;
						}
//						if they want to spend more points than they have available.
					else if (spendInput > player.stat_points) {
						System.out.println("You don't have " + spendInput + " points available to spend. ");
						System.out.println("Current available points: " + player.stat_points + ".\n ");
						}
				}
				else if (input.equals("cancel")) {
					System.out.println("Canceling spend points. ");
					break;
				}
			}
		}
//		Invalid amount of points.
		else if (player.stat_points <= 0) {
			System.out.println("You don't have enough points available to spend.\n ");
			}
		}

	public void calculate_stats(Player player) {	
		player.max_hp = player.endurance * 2 + player.level;
//		heal them up to new full hp.
		player.hp = player.max_hp;
		
//		plus w/e weapon the use?
		player.damage_value = player.strength / 2 + player.level;
		}
	
	public void level_up_check(Player player) {
		if (player.current_exp >= player.next_level_exp) {
			System.out.println(player.name + " has leveled up! ");

			
//			Crossover xp is the remainder of what is left after using enough to level up once.
			int crossover_xp = player.current_exp - player.next_level_exp;
//			Level increase.
			player.level += 1;
			System.out.println(player.name + " is now level: " + player.level + "! ");
//			Stat points to be spent
			player.stat_points += 2;
			System.out.println(player.name + " earned 2 more stat points and now has: " + player.stat_points + " unspent points! ");
			calculate_stats(player);

			System.out.println(player.name + " has: " + player.current_exp + " experience. ");
			System.out.println(player.name + " next level at: " + player.next_level_exp + " experience. ");
			
//			player.current_exp += player.next_level_exp;
			player.next_level_exp += (int) Math.pow(player.current_exp, 1.1);
			player.current_exp += crossover_xp;
//			Final step to handle crossover xp.
			level_up_check(player);
			}
		}
	
	public String print_details(Player player) {
		return ("\nPlayer Info: \nName: " + name + ". "
				+ "\nAge: " + age + "."
				+ "\nHitpoints: " + hp + "/" + max_hp + ". "
				+ "\nUnspent points: " + stat_points + ". "
				+ "\nEndurance: " + endurance + ". "
				+ "\nStength: " + strength + ". "
				+ "\nArmor: " + defense_value + ". "
				+ "\nDamage: " + damage_value + ". "
				+ "\nLevel: " + level + ". "
				+ "\nExperience: " + current_exp + ". "
				+ "\nNext Level: " + next_level_exp + ". "
				+ "\nPlaceholder for inventory/money: " + currency + ".\n ");
		}
	
	  public static void character_creation(Player player) {
		  System.out.println("___________________");
		  System.out.println("|CHARACER CREATION|");
		  System.out.println("Do you want to build your own character? ");
		  String input = "";
		  
		  while (!input.equals("yes")) {
			  Scanner scanner = new Scanner(System.in);
			  input = scanner.next();
			  
//			  Custom character.
			  if (input.equals("yes")) {
				  System.out.println("What's your name? ");
				  String name = "";
				  name = scanner.next();
				  player.name = name;
				  System.out.println("Your name is: " + player.name + ". ");
				  
				  int age = 0;
				  System.out.println("\nWhat's your age? ");
				  while (age < 10 || age > 90) {
//					  When we don't have an int, we're going to stay here until we do.
					  while(!scanner.hasNextInt()) {
					      scanner.next();
					      System.out.println("Please type a valid number. ");
					      }
//					  Soon as we leave the loop with an int, we put it into the age variable.
					  age = scanner.nextInt();
//					  now we examine the number a little.
					  if (age < 10) {
						  System.out.println("You're too young! ");
						  continue;
						  }
					  else if (age > 90) {
						  System.out.println("You're too old! ");
						  continue;
						  }
//					  We accept the number!
					  else if (age >= 10 && age <= 90) {
						  player.age = age;
						  System.out.println("\nYour age is: " + player.age + ". ");
						  player.spend_points(player);
			//			  calc stat output based on inputs.
						  player.calculate_stats(player);
						  System.out.println(player.print_details(player));
						  }
					  }
				  }
//			  Default character.
			  else if (input.equals("no")) {
				  System.out.println("Using the default player object made in Main.\n ");
				  System.out.println(player.print_details(player));
				  break;
				  }
//			  Invalid input.
			  else {
				  System.out.println("Please type [yes] or [no]");
				  }
			  }
		  }

// HP recovery mechanic.
	public static void sleep_at_tavern(Player player) {
		Random rand = new Random();
		
		int short_stay_cost = player.level * 2 + 1;
		int long_stay_cost = player.level * 3 + 2;
		System.out.println("\n'Welcome to the tavern!' It costs: " + short_stay_cost + " for a short stay and: " + long_stay_cost + " for a long stay.\n ");
		System.out.println("You currently have: " + player.currency + " gold.\n ");
		System.out.println("Options: [short], [long], [back] ");
		String input = "";
		Scanner scanner = new Scanner(System.in);
		input = scanner.next();
		
		while (!input.equals("short") || !input.equals("long") || !input.equals("back")) {
			
			if (input.equals("short")) {
				if (player.currency < short_stay_cost) {
					System.out.println("You don't have enough gold! ");
					System.out.println("You need: " + short_stay_cost + "gold. ");
					System.out.println("You only have: " + player.currency + "gold. ");
					}
//				LOW HEAL
				else if (player.currency >= short_stay_cost) {
					int heal_amount = rand.nextInt((short_stay_cost + 5) / 2);
					System.out.println("You healed: " + heal_amount + " HP after resting.");
					player.hp += heal_amount;
					player.currency -= short_stay_cost;
					if (player.hp > player.max_hp) {
						player.hp = player.max_hp;
						}
					System.out.println("Current HP: " + player.hp + "/" + player.max_hp + ".\n ");
					break;
					}
			}
			else if (input.equals("long")) {
				if (player.currency < long_stay_cost) {
					System.out.println("You don't have enough gold! ");
					System.out.println("You need: " + long_stay_cost + "gold. ");
					System.out.println("You only have: " + player.currency + "gold. ");
					}
//				FULL HEAL
				else if (player.currency >= long_stay_cost) {
					int heal_amount = player.max_hp - player.hp;
					player.hp += heal_amount;
					player.currency -= long_stay_cost;
					System.out.println("You healed: " + heal_amount + " HP after resting.");
					System.out.println("Current HP: " + player.hp + "/" + player.max_hp + ".\n ");
					break;
					}
				}
			else if (input.equals("back")) {
				System.out.println("You walk away from the barkeep. ");
				break;
				}
			}
		}
	}