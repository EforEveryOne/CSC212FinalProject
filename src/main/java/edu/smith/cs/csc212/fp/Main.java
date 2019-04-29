package edu.smith.cs.csc212.fp;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.smith.cs.csc212.fp.Place;
import edu.smith.cs.csc212.fp.Exit;

//import edu.smith.cs.csc212.p4.Exit;
//import edu.smith.cs.csc212.p4.Place;
//import edu.smith.cs.csc212.p4.SecretExit;

// For Testing
public class Main {
  public static boolean returnsTrue() {
    return true;
  }
  
  public static void play_game() {
	  System.out.println("Play game? ");
	  String input = "";
	  
//	  https://stackoverflow.com/questions/39524599/how-do-i-loop-until-the-user-makes-correct-input-on-java
	  while (!input.equals("yes")) {
		  Scanner scanner = new Scanner(System.in);
		  input = scanner.next();
//		  Move to character creation.
		  if (input.equals("yes")) {
			  System.out.println("Starting... ");
			  Player.character_creation();
			  }
//		  Quit.
		  else if (input.equals("no")) {
			  System.out.println("Game over before it began... ");
			  break;
			  }
//		  Invalid input.
		  else {
			  System.out.println("Please type 'yes' or 'no'");
			  }
		  }
	  }

//does method take in arguments?
//should know current zone so that it knows where player is.
public static void call_player_methods() {
//	we will call this in zones to be able to process input w/o repeating code?
//	with the graph/zone/nodes we can just node.exit/next sort of thing?
//	can refer to node.name (place.description?) 
	
}


private Map<String, Place> places = new HashMap<>();
public String getStart() {
	return "town";
}

//public GameZones() {}

protected Place insert(Place p) {
	places.put(p.getId(), p);
	return p;
}





public static void main(String[] args) {
	  play_game();
//	  GameZones();
	  GameZones game = new GameZones();
	  String place = game.getStart();
//	  System.out.println(game.getStart());
		while (true) {
			Place here = game.getPlace(place);
//			System.out.println(here.getDescription());
			
			List<Exit> exits = here.getVisibleExits();
			for (int i=0; i<exits.size(); i++) {
			    Exit e = exits.get(i);
				System.out.println(" ["+i+"] " + e.getDescription());
			}
			
//			TOWN ZONE/INPUT
			if (here.getId() == "town") {
				System.out.println("town time! ");
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				  
				int intValue = Integer.parseInt(input);
				
				  // Move to the room they indicated.
				Exit destination = exits.get(intValue);
				place = destination.getTarget();
				}
//			TAVERN ZONE/INPUT
			else if (here.getId() == "tavern") {
				System.out.println("tavern time! ");
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				  
				int intValue = Integer.parseInt(input);
				
				  // Move to the room they indicated.
				Exit destination = exits.get(intValue);
				place = destination.getTarget();
				}
//			SHOP ZONE/INPUT
			else if (here.getId() == "shop") {
				System.out.println("shop time! ");
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				  
				int intValue = Integer.parseInt(input);
				
				  // Move to the room they indicated.
				Exit destination = exits.get(intValue);
				place = destination.getTarget();
				}
//			WILDERNESS ZONE/INPUT
			else if (here.getId() == "wilderness") {
				System.out.println("wilderness time! ");
				String input = "";
				Scanner scanner = new Scanner(System.in);
				input = scanner.next();
				  
				int intValue = Integer.parseInt(input);
				
				  // Move to the room they indicated.
				Exit destination = exits.get(intValue);
				place = destination.getTarget();
				}
			
			
//		end while loop	
		}
	  

		
		
		

	  }
  }

