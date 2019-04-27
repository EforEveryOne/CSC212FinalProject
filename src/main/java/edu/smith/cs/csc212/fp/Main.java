package edu.smith.cs.csc212.fp;


import java.util.Scanner;

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
  

  
//  takes in arg for each variable needed to build player?
public static void calculate_character() {
//	int max_hp,
//	int stat_points,
//	int endurance,
//	int strength,
//	int armor,
//	int damage, 
//	int defense_value, 
//	int damage_value,
//	int level,
//	int current_exp,
//	int next_level_exp,
//	int currency
	
//	hp = endurance + level * 2
//	dmg = strength + level * 2
//	armor = 0
//	dmg base 1	
}

//does method take in arguments?
//should know current zone so that it knows where player is.
public static void call_player_methods() {
//	we will call this in zones to be able to process input w/o repeating code?
//	with the graph/zone/nodes we can just node.exit/next sort of thing?
//	can refer to node.name (place.description?) 
	
}




public static void main(String[] args) {
	  play_game();

	  }
  }

