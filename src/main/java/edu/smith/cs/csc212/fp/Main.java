package edu.smith.cs.csc212.fp;


import java.util.Scanner;


// For Testing
public class Main {
  public static boolean returnsTrue() {
    return true;
  }
  
  public static void play_game() {

	  Scanner scanner = new Scanner(System.in);
	  System.out.println("Play game? ");
//	  String text = scanner.nextLine();
	  
	  String input = "";
	  String target_text = "yes";
	  
//	  https://stackoverflow.com/questions/39524599/how-do-i-loop-until-the-user-makes-correct-input-on-java
	  while (!input.equals(target_text)) {
		  input = scanner.next();
		  
		  if(input.equals(target_text)) {
			  System.out.println("Starting... ");
//			  close scanner.
			  scanner.close();
			  character_creation();
			  }
		  else if (input.equals("no")) {
			  scanner.close();
			  System.out.println("Game over before it began... ");
			  break;
		  }
		  else {
			  System.out.println("Please type 'yes' or 'no'");
		    }
		  }
	  }		

  

  
  
  
  private static void character_creation() {
	  Scanner scanner = new Scanner(System.in);
	  String input = "";
	  String target_text = "yes";
	  
	  while (!input.equals(target_text)) {
		  input = scanner.next();
		  
	  }
	  
	  
	  
	// TODO Auto-generated method stub
	
}

public static void main(String[] args) {
		
	  Player player = new Player("TestName", 10, 10, 5, 5, 0, 1, 1, 1, 0, 100, 10, 0, 0);
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

// does method take in arguments?
// should know current zone so that it knows where player is.
private static void call_player_methods() {
	// TODO Auto-generated method stub
//	we will call this in zones to be able to process input w/o repeating code?
//	with the graph/zone/nodes we can just node.exit/next sort of thing?
//	can refer to node.name (place.description?) 
	
}
  }

