package edu.smith.cs.csc212.fp;


import java.util.Scanner;


// For Testing
public class Main {
  public static boolean returnsTrue() {
    return true;
  }
  
  
  

  public static void main(String[] args) {
		
	  Player player = new Player("TestName", 10, 10, 5, 5, 0, 1, 1, 1, 0, 100, 10, 0, 0);
	  
	  
//	  Ideally this would work and be easy but it works specifically for the console, it throws an error in an IDE.
//	  https://www.admfactory.com/how-to-get-input-from-java-console/
	  //    String testingUserInput = System.console().readLine();
//    System.out.println(testingUserInput);
    
	  
//	  How we read user input
	  Scanner scanner = new Scanner(System.in);
//	  remember to close scanner later
			
			
	  
	  while (true) {
		  System.out.println("Input: ");
		  String text = scanner.nextLine();
		  if (text.equalsIgnoreCase("yes")){
			  System.out.println(player.print_details());
//			  player.print_details();
//			  System.out.println("test!");
			  
			  break;
		  }
	  }
	  }
  }

