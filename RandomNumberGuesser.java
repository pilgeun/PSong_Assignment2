/*
 * Class: CMSC203 CRN 46519
 * Instructor: Farnaz Eivazi
 * Description: Asks user to guess a random number between 0 and 100, giving 7 chances to guess correctly.
 * Due: 6/30/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Philip Song
*/

import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in); 
		
		int randNum, 	// stores value for random number created by RNG.rand()
			nextGuess, 	// stores number of user's guess
			lowGuess, 	// stores value of lowest number user can guess
			highGuess,	// stores value of highest number user can guess
			count;		// stores # of guesses
		char again;		// stores user response to playing again
	
		do	
		{
			randNum = RNG.rand();	// generates random number between 0 and 100
			RNG.resetCount();		
			count = 1;				// reset # of guesses 
			
			// resets default values for lowGuess and highGuess		
			lowGuess = 0; 
			highGuess = 100;
			
			//BACKDOOR FOR TEST PURPOSES
			System.out.println(randNum + "\n");
			
			System.out.println("Enter your first guess");
			
			for( ; count <= 7; count++)
			{
				nextGuess = keyboard.nextInt();
				
				// if user makes invalid guess (outside range between lowGuess and highGuess), it will loop until user gives valid input
				while(!RNG.inputValidation(nextGuess, lowGuess, highGuess))	
					nextGuess = keyboard.nextInt();
				
				System.out.println("Number of guesses is " + count);
				
				// ends loop if user enters correct number or makes 7th guess 
				if (nextGuess == randNum)
					break;
				
				// if user guess is lower than correct number, update the lowest number user can guess
				else if (nextGuess < randNum) {		
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				
				// if user guess is higher than correct number, update the highest number user can guess
				else if (nextGuess > randNum) {	
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				}
				
				if (count < 7)
					System.out.println("Enter your next guess between " +lowGuess+ " and " +highGuess);
			}
			
			if (count > 7)
				System.out.println("Answer was " +randNum);
				
			else
				System.out.println("Congratulations, you guessed correctly");			
			
			
			System.out.println("Try again? (yes or no)");
			
			// user input starting with Y or y is 'yes', anything else will be 'no'
			again = Character.toLowerCase(keyboard.next().charAt(0));	
			keyboard.nextLine();
			
			if (again == 'y')
				System.out.println("\n");
			
		} while(again == 'y');	// go back to the beginning, if user wants to try again
		
		keyboard.close();
		
		System.out.println("Thanks for playing...");
		System.out.println("\nPROGRAMMER: Philip Song");
	}
	
	
}
