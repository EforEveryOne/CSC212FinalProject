package edu.smith.cs.csc212.fp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.smith.cs.csc212.fp.Place;
import edu.smith.cs.csc212.fp.Exit;

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
5, //strength
0, // armor value
1, // damage value, base 1.
1, // level, base 1. 
0, // xp
100, // next lvl xp
100, // currency
false, inventory); // priority for turn
  
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
	System.out.println("You look around and notice: ");
	System.out.println(here.getDescription());
	}




public static void main(String[] args) {
	  play_game(player);
	  GameZones game = new GameZones();
	  String place = game.getStart();
	  while (true) {
		  Place here = game.getPlace(place);

		  
		  System.out.println("______________________");
		  System.out.println("| you are in: " + here.getId() + "|");
		  
		  List<Exit> exits = here.getVisibleExits();
		  for (int i=0; i<exits.size(); i++) {
			  Exit e = exits.get(i);
			  System.out.println(" ["+i+"] " + e.getDescription());
			  }
			
//			Need to handle correct type input, we want a number, anything else crashes it, so handle it.
//			TOWN ZONE/INPUT
//			should be while instead of if?
			if (here.getId() == "town") {
				System.out.println(here.options());
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				if (input.equals("search")) {
					place_details(here);
					}
				
//				final step is to leave the location. 
				try {
					int intValue = Integer.parseInt(input);
					
					// Move to the room they indicated.
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
				} catch (Exception e) {
//					System.out.println("\n\nPlease type a valid option [0], [1], [search]\n ");
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
				if (input.equals("search")) {
					place_details(here);
					}
				else if (input.equals("sleep")) {
					Player.sleep_at_tavern(player);
					}
				try {
					int intValue = Integer.parseInt(input);
					
					// Move to the room they indicated.
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
				} catch (Exception e) {
//					TO DO
//					SLEEP spend night at the tavern, heal up character. costs gold.
//					System.out.println("\n\nPlease type a valid option: [0], [search], [sleep]\n ");
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
				try {				
					int intValue = Integer.parseInt(input);
					
					// Move to the room they indicated.
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
				} catch (Exception e) {
					System.out.println("Please type a valid input.\n ");
					continue;
					}
				}
			
//			WILDERNESS ZONE/INPUT
			else if (here.getId() == "wilderness") {
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				System.out.println(here.options());
				try {				
					int intValue = Integer.parseInt(input);
					
					// Move to the room they indicated.
					Exit destination = exits.get(intValue);
					place = destination.getTarget();
				} catch (Exception e) {
					System.out.println("Please type a valid input.\n ");
					continue;
					}
				}
			
			
//		end while loop	
		}
	  

		
		
		

	  }
  }

