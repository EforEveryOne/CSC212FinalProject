package edu.smith.cs.csc212.fp;

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
			int currency) {
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
				System.out.println("Options: 'endurance' or 'strength' or 'cancel' ");
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
	
	
	
	
//	don't think this is needed... can just call level_up even for initial creation?
	public void calculate_stats(Player player) {	
		player.max_hp = player.endurance * 2 + player.level;
//		heal them up to new full hp.
		player.hp = player.max_hp;
		
//		plus w/e weapon the use?
		player.damage_value = player.strength / 2 + player.level;
		}
	
	public void level_up_check(Player player) {
		if (player.current_exp >= player.next_level_exp) {
			
//			Crossover xp is the remainder of what is left after using enough to level up once.
			int crossover_xp = player.current_exp - player.next_level_exp;
//			Level increase.
			player.level += 1;
//			Stat points to be spent
			player.stat_points += 2;
			
			calculate_stats(player);
			
//			player.current_exp += player.next_level_exp;
			player.next_level_exp += (int) Math.pow(player.current_exp, 1.1);
			player.current_exp += crossover_xp;
//			Final step to handle crossover xp.
			level_up_check(player);
			}
		}
	
	public String print_details() {
		return ("\nPlayer Info: \nName: " + name + "."
				+ "\nAge: " + age + "."
				+ "\nHitpoints: " + hp + "/" + max_hp + "."
				+ "\nUnspent points: " + stat_points + "."
				+ "\nEndurance: " + endurance + "."
				+ "\nStength: " + strength + "."
				+ "\nArmor: " + defense_value + "."
				+ "\nDamage: " + damage_value + "."
				+ "\nLevel: " + level + "."
				+ "\nExperience: " + current_exp + "."
				+ "\nNext Level: " + next_level_exp + "."
				+ "\nPlaceholder for inventory/money: " + currency + ".");
		}
	
	
	
	  public static void character_creation() {
		  System.out.println("___________________");
		  System.out.println("|CHARACER CREATION|");
		  System.out.println("Do you want to build your own chracter from scratch?");
		  String input = "";
		  
		  while (!input.equals("yes")) {
			  Scanner scanner = new Scanner(System.in);
			  input = scanner.next();
//			  System.out.println("This is the current input: " + input);
//			  System.out.println(player.print_details());
			  
//			  Custom character.
			  if (input.equals("yes")) {
//				  Build blank character, modify by user input.
				  Player player = new Player("TestName", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				  System.out.println("What's your name? ");
				  String name = "";
				  name = scanner.next();
				  player.name = name;
				  System.out.println("Your name is: " + player.name + ". ");
				  
				  int age = 0;
				  System.out.println("\nWhat's your age? ");
//				  While age is not between 10 and 90.
				  
//				  Scanner scan = new Scanner(System.in);

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
						  
			//			  Set base stats and free points.
						  player.endurance += 5;
						  player.strength += 5;
						  player.stat_points += 5;
						  player.next_level_exp = 100;
			//			  spend skill points now.
						  player.spend_points(player);
			//			  calc stat output based on inputs.
						  player.calculate_stats(player);
						  }
					  }
				  }
//			  Default character.
			  else if (input.equals("no")) {
				  Player player = new Player(
						  "DefaultDan", // name
						  10, // age
						  45, // hp
						  10, // max_hp
						  5, // skill points
						  5, // endurance
						  5, //strength
						  1, // armor value
						  1, // damage value, base 1.
						  1, // level, base 1. 
						  0, // xp
						  100, // next lvl xp
						  0); // money

				  System.out.println(player.print_details());
				  break;
				  }
//			  Invalid input.
			  else {
				  System.out.println("Please type 'yes' or 'no'");
				  }
			  }
		  }
	
//	handle gold/items in player class or separate class?
//	think it makes sense to do in here because I could do the same thing for enemies.
//	if inventory is it's own class, does that mean it's "universal"?
//	would make it difficult to handle multiple inventories?
	
//	or just have a player inventory which extends/supers inventory?
	
	
	

}
