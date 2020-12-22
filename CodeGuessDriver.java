/*
 * Name: Adam Plater-Zyberk
 * Student Number: 040 922 567
 * Course: CST8110
 * Semester: S20
 * Assignment 3
 * Due date: Sunday July 26, 2020 by 11:59pm
 */

//class to execute code guessing game 
public class CodeGuessDriver {

	//main method to initialize CodeGuessGame object and display welcoming instructions
	public static void main(String[] args) {

		System.out.println("***Welcome to the Code Guessing Game***\n");

		CodeGuessGame Guesser = new CodeGuessGame();

		int guessNumber=1;
		int totalGuess=7;

		System.out.println("You have 6 tries to find the secret 3 letter code");
		System.out.println("The letters range from A to C\n");
		System.out.println("The code can have repeat letters\n");

		//implement selection structure to invoke getGuess and checkGuess methods for validity iteration and state of done() method
		while (guessNumber <= totalGuess && !Guesser.done()) {

			if(guessNumber == totalGuess) {
				System.out.println("You lose");
				System.out.println("The correct code was " + Guesser.display());
				return;
			}
			else{
				Guesser.getGuess(guessNumber);
			}
			if (!Guesser.done()){
				Guesser.checkGuess();
			}
			guessNumber++;
		} 

		//invokes display method to display correct code guess
		System.out.println("The correct code was " + Guesser.display());
		return;

	}//end of main method
}//end of CodeGuessDriver class
