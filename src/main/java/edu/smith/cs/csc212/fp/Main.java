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
			  character_creation();
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
  
  private static void character_creation() {
	  System.out.println("___________________");
	  System.out.println("|CHARACER CREATION|");
	  System.out.println("Do you want to build your own chracter from scratch?");
	  String input = "";
	  
	  while (!input.equals("yes")) {
		  Scanner scanner = new Scanner(System.in);
		  input = scanner.next();
//		  System.out.println("This is the current input: " + input);
//		  System.out.println(player.print_details());
		  
//		  Custom character.
		  if (input.equals("yes")) {
//			  Build blank character, modify by user input.
			  Player player = new Player("TestName", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
			  System.out.println("What's your name? ");
			  String name = "";
			  name = scanner.next();
			  player.name = name;
			  System.out.println("Your name is: " + player.name + ". ");
			  
			  int age = 0;
			  System.out.println("\nWhat's your age? ");
//			  While age is not between 10 and 90.
			  while (age < 10 || age > 90) {
				  try {
				  age = scanner.nextInt();
				  }
				  catch (Exception err) {
					  System.out.println("Please type a valid number. ");
					  continue;
					  }
				  if (age < 10) {
					  System.out.println("You're too young! ");
					  }
				  if (age > 90) {
					  System.out.println("You're too old! ");
					  }
				  if (age > 10 && age < 90) {
					  player.age = age;
					  System.out.println("\nYour age is: " + player.age + ". ");
					  }
				  }
//			  spend skill points now.
			  }
//		  Default character.
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
			  
			  
			  
// 			  feed in auto variables for quick gen
//			  Player.calculate_stats(input, 0, 0);
			  }
//		  Invalid input.
		  else {
			  System.out.println("Please type 'yes' or 'no'");
			  }
		  }
	  }
  
//  takes in arg for each variable needed to build player?
private static void calculate_character() {
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
private static void call_player_methods() {
//	we will call this in zones to be able to process input w/o repeating code?
//	with the graph/zone/nodes we can just node.exit/next sort of thing?
//	can refer to node.name (place.description?) 
	
}




public static void main(String[] args) {
	  play_game();
//	  call_player_methods();
	  
//	  Ideally this would work and be easy but it works specifically for the console, it throws an error in an IDE.
//	  https://www.admfactory.com/how-to-get-input-from-java-console/
	  //    String testingUserInput = System.console().readLine();
//    System.out.println(testingUserInput);
    
	  
////	  How we read user input
//	  Scanner scanner = new Scanner(System.in);
////	  remember to close scanner later
//	  while (true) {
//		  System.out.println("Make character? \n ");
//		  String text = scanner.nextLine();
//		  if (text.equalsIgnoreCase("yes")){
//			  System.out.println(player.print_details());
////			  player.print_details();
////			  System.out.println("test!");
//			  
//			  break;
//		  }
//	  }
	  }
  }

