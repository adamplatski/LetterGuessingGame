/*
 * Name: Adam Plater-Zyberk
 * Student Number: 040 922 567
 * Course: CST8110
 * Semester: S20
 * Assignment 3
 * Due date: Sunday July 26, 2020 by 11:59pm
 */

import java.util.Random;
import java.util.Scanner;

//class to declare private fields and instantiate objects
public class CodeGuessGame {

	private String code;
	private String guess;
	private boolean done;
	private Random random = new Random();
	private Scanner scan = new Scanner(System.in);

	// locally declared characters are created,concatenated and stored in the string variable "code"
	public CodeGuessGame() {

		char input1 = (char)(random.nextInt(3)+65);
		char input2 = (char)(random.nextInt(3)+65);
		char input3 = (char)(random.nextInt(3)+65);

		code = String.valueOf(input1) + String.valueOf(input2) + String.valueOf(input3);

	}

	//uses integer input parameter to prompt user for code guess or option to quit, then validates correct guess length and correct characters
	public void getGuess(int guessCount) {

		boolean correctGuess = false;

		//takes in code guess from user and validates their guess length or option to quit game
		while(!correctGuess) {

			System.out.print("Enter guess # "+guessCount+":");
			guess=scan.nextLine().toUpperCase();

			if(guess.equals("QUIT")) {
				System.out.println("You lose");
				done=true;
				return;
			}
			else if (guess.length() >3) {
				System.out.println("Guess is too long");
			}
			else if(guess.length() < 3) {
				System.out.println("Guess is too short");
			}

			//invokes isValid method to verify validity of each entered letter
			else {	

				if (!(isValid(guess.charAt(0)))) {
					System.out.println(guess.charAt(0)+ " is not a valid first letter");				
				}
				else if(!(isValid(guess.charAt(1)))) {
					System.out.println(guess.charAt(1)+" is not a valid second letter");		
				}
				else if(!(isValid(guess.charAt(2)))) {
					System.out.println(guess.charAt(2)+" is not a valid third letter");		
				}
				else {
					correctGuess = true;
				}

			}
		}	

	}

	//uses locally declared integer variable to keep track of correct letter count and correct code matching
	public void checkGuess() {

		int checker = 0;

		guess = guess.toUpperCase();

		for (int z = 0; z < 3; z++) {

			if (guess.charAt(z) == code.charAt(z)) {
				checker++;

			}
		}

		//outputs to user how many correct letters they entered or if they won
		if (checker == 3) {
			System.out.println("You Win!");
			done=true;
		}	
		else if(checker == 0) {
			System.out.println("0 letters are in the correct space");
		}
		else if(checker == 1) {
			System.out.println("1 letter is in the correct space");
		}
		else if(checker == 2) {
			System.out.println("2 letters are in the correct space");
		}



	} 

	//return type method to display the correct code guess whether user quits, loses, or wins
	public String display() {
		return code;
	}

	//receives single character as input parameter, returning boolean using selection structure to verify valid character input
	private boolean isValid(char z) {

		z = Character.toUpperCase(z);

		if(z == 'A' || z == 'B' || z == 'C') {
			return true;
		}else {
			return false;
		}
	}

	//return type method for program to know when the 6 guess attempts are complete or not
	public boolean done() {
		return done;
	}
}//end of CodeGuessGame class