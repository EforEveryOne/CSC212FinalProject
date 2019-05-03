package edu.smith.cs.csc212.fp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.smith.cs.csc212.fp.Place;
import edu.smith.cs.csc212.fp.Exit;
//import edu.smith.cs.csc212.fp.Combat;
import edu.smith.cs.csc212.fp.Enemy;
//import edu.smith.cs.csc212.fp.Player;

// For Testing
public class Main {
  public static boolean returnsTrue() {
	  return true;
	  }



private static ArrayList<Item> inventory;
 
static Player player = new Player(
		
		"DefaultDan", // name
		10, // age
		45, // hp
		10, // max_hp
		5, // skill points
		5, // endurance
		5, // strength
		0, // armor value
		1, // damage value, base 1.
		1, // level, base 1. 
		0, // xp
		100, // next lvl xp
		20, // currency
		false,
		0, // kill_count
		inventory); // priority for turn

static Enemy enemy = new Enemy(
		null,
		0,
		0,
		0,
		0,
		0, 
		0);
  
  public static void play_game(Player player) {
	  System.out.println("Play game? ");
	  String input = "";
	  
//	  https://stackoverflow.com/questions/39524599/how-do-i-loop-until-the-user-makes-correct-input-on-java
	  while (!input.equals("yes")) {
		  Scanner scanner = new Scanner(System.in);
		  input = scanner.next();
//		  Move to character creation.
		  if (input.equals("yes")) {
			  System.out.println("Starting... ");
			  Player.character_creation(player);
			  }
//		  Quit.
		  else if (input.equals("no")) {
			  System.out.println("Game over before it began... ");
			  break;
			  }
//		  Invalid input.
		  else {
			  System.out.println("Please type [yes] or [no]");
			  }
		  }
	  }

//does method take in arguments?
//should know current zone so that it knows where player is.
public static void call_player_methods(Player player, GameZones gamezones) {
//	if (gamezones.getPlace(id) == "town") {
	}
//	we will call this in zones to be able to process input w/o repeating code?
//	with the graph/zone/nodes we can just node.exit/next sort of thing?
//	can refer to node.name (place.description?) 
	



private Map<String, Place> places = new HashMap<>();
public String getStart() {
	return "town";
	}

protected Place insert(Place p) {
	places.put(p.getId(), p);
	return p;
	}

public static void place_details(Place here) {
	System.out.println("\nYou look around and notice: ");
	System.out.println(here.getDescription() + "\n ");
	}




public static void main(String[] args) {
	  play_game(player);
	  GameZones game = new GameZones();
	  String place = game.getStart();
	  
//	  As long as the player lives...
	  while (player.hp > 0) {
		  Place here = game.getPlace(place);

		  
		  System.out.println("\n______________________");
		  System.out.println("| you are in: " + here.getId() + " |");
		  
		  List<Exit> exits = here.getVisibleExits();
		  for (int i=0; i<exits.size(); i++) {
			  Exit e = exits.get(i);
			  System.out.println(" [" + i + "] " + e.getDescription());
			  }
			
//			TOWN ZONE/INPUT
			if (here.getId() == "town") {
				System.out.println(here.options());
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
			
//	Specific input
				if (input.equals("search")) {
					place_details(here);
					continue;
					}
				else if (input.equals("player")) {
					System.out.println(player.print_details(player));
					player.offer_spend_points(player);
					continue;
					}
//				final step is to leave the location. 
				try {
					int intValue = Integer.parseInt(input);
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
				} catch (Exception e) {
//					System.out.println("\n\nPlease type a valid option [0], [1], [details]\n ");
					System.out.println("Please type a valid input.\n ");
					continue;
					}
				}
			
//			TAVERN ZONE/INPUT
			else if (here.getId() == "tavern") {
				System.out.println(here.options());
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				
//	Specific input
				if (input.equals("search")) {
					place_details(here);
					continue;
					}
				else if (input.equals("player")) {
					System.out.println(player.print_details(player));
					player.offer_spend_points(player);
					continue;
					}
				else if (input.equals("sleep")) {
					Player.sleep_at_tavern(player);
					continue;
					}
//				final step is to leave the location. 
				try {
					int intValue = Integer.parseInt(input);
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
					}
				catch (Exception e) {
//					TO DO
//					SLEEP spend night at the tavern, heal up character. costs gold.
//					System.out.println("\n\nPlease type a valid option: [0], [details], [sleep]\n ");
					System.out.println("Please type a valid input.\n ");
					continue;
					}
				}
			
//			SHOP ZONE/INPUT
			else if (here.getId() == "shop") {
				System.out.println(here.options());
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();

//	Specific input
				if (input.equals("search")) {
					place_details(here);
					continue;
					}
				else if (input.equals("player")) {
					System.out.println(player.print_details(player));
					player.offer_spend_points(player);
					continue;
					}
				else if (input.equals("buy")) {
//					TODO
					System.out.println("TODO: BUY FROM SHOP");
					continue;
					}
				else if (input.equals("sell")) {
//					TODO
					System.out.println("TODO: SELL TO SHOP");
					continue;
					}
				
//				final step is to leave the location. 
				try {				
					int intValue = Integer.parseInt(input);
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
					}
				catch (Exception e) {
					System.out.println("Please type a valid input.\n ");
					continue;
					}
				}
			
//			WILDERNESS ZONE/INPUT
			else if (here.getId() == "wilderness") {
				System.out.println(here.options());
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
//	Specific input
				if (input.equals("search")) {
					place_details(here);
					continue;
					}
				else if (input.equals("player")) {
					System.out.println(player.print_details(player));
					player.offer_spend_points(player);
					continue;
					}
				else if (input.equals("explore")) {
//					Build the enemy.
					Enemy.roll_random_enemy(enemy);
					
//					Put the enemy and the player into the encounter.
					Combat.combat(player, enemy);
					continue;
					}
				
//				final step is to leave the "location".
				try {				
					int intValue = Integer.parseInt(input);
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
					}
				catch (Exception e) {
					System.out.println("Please type a valid input. ");
					continue;
					}
				}
			}
	  System.out.println("GAME OVER. ");
	  System.out.println("You defeated: " + player.kill_count + " total enemies! ");
	  }
}