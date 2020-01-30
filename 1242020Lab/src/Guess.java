import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This is a skeleton of code for a guessing game
 * that uses a bag. The bag is filled with random
 * integers, and the user repeatedly tries to guess
 * what those numbers are. There are some utility
 * methods to help you, but you should write additional
 * methods to organize your code.
 * 
 * @author Jacob Schrum
 * Last modified 5/29/18
 */
public class Guess {

	/** Main Method
	 * Create a Scanner and play the game as long as the user
	 * answers "yes" to the main prompt.  
	 * @param args Not used
	 */
	
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while (yesTo("Do you want to play the guessing game?", console)){
			int largestNum = positiveInt("What is the largest number that can be in the bag?", console);
			int numItems = positiveInt("How many items are in the bag?", console);
			ArrayBag<Integer> randBag = fillRandomBag(largestNum, numItems);
			System.out.println(Arrays.toString(randBag.toArray()));
			
			//loop once per round of guesses
			while(userGuesses(numItems, console, randBag, largestNum));
			
		}
	}

	/** Method for filling the bag 
	 * @param largestNum largest int that the bag can take
	 * @param numItems number of items in the bag
	 * @return a bag with numItems number of items from 1 up to largestNum
	 */
	private static ArrayBag<Integer> fillRandomBag(int largestNum, int numItems) {
		Random rand = new Random();
		ArrayBag<Integer> randBag = new ArrayBag<>(numItems);
		for(int i = 0; i < numItems; i++) {
			randBag.add(rand.nextInt(largestNum)+1);
			
		}
		return randBag;
	}

	// TODO: Other methods that break the problem into pieces for playing the game.

	/**
	 * Utility function that prompts the user to enter
	 * a single positive integer, which is then returned.
	 * Invalid responses cause the prompt to repeat until
	 * the user provides correct input. Do not change this
	 * method.
	 * @param prompt text of the question prompt
	 * @param console a Scanner of the console
	 * @return positive integer entered by user
	 */
	public static int positiveInt(String prompt, Scanner console) {
		for(;;) {
			System.out.print(prompt + " ");
			if(console.hasNextInt()) {
				int input = console.nextInt();
				if(input > 0) {
					return input;
				}
			} else {
				// Discard non-integer token
				console.next();
			}
			System.out.println("Please answer with a positive integer.");
		}
	}

	/**
	 * Utility function to ask user yes or no.
	 * No modifications are necessary for this method.
	 * It uses a forever loop -- but the loop stops when something is returned.
	 * @param prompt text of the question prompt
	 * @param console a Scanner of the console
	 * @return true if y is entered, false if n is entered
	 */
	public static boolean yesTo(String prompt, Scanner console) {
		for (;;) {
			System.out.print(prompt + " (y/n)? ");
			String response = console.next().trim().toLowerCase();
			if (response.equals("y"))
				return true;
			else if (response.equals("n"))
				return false;
			else
				System.out.println("Please answer y or n.");
		}
	}
	
	
	
	/**
	 * Method for receiving and checking if a user's guess is correct.
	 * @param numItems an integer that gives the number of items in the bag
	 * @param console to receive the users input 
	 * @param randBag holds the random numbers that the guesses are compared to
	 * @return false if all the guesses are correct, and true if all the guesses are not correct.
	 */
	//helped Chris and his partner on this Method and the while loop in main
	public static boolean userGuesses(int numItems, Scanner console, ArrayBag<Integer> randBag, int largestNum) {
		System.out.println("Try to guess the numbers in the bag.\nThere are " + numItems + " numbers from 1 to " + largestNum + ".");
		ArrayBag<Integer> userBag = new ArrayBag<>(numItems);
		int counter = 0;
		int[] tempArray = new int[numItems];
		for(int i = 0; i < numItems; i++) {
			System.out.print("Guess for item #" + (i+1) + ": " );
			int temp = console.nextInt();
			tempArray[i] = temp;
			
		}
		
		for(int k = 0; k < numItems; k++) {
			if(randBag.contains(tempArray[k])) {
				userBag.add(tempArray[k]);
				if(!(userBag.getFrequencyOf(tempArray[k]) > randBag.getFrequencyOf(tempArray[k]))) {
					counter++;
				}
			}
			
		}
		
	
		if(counter == numItems) {
			System.out.println("You are correct!");
			return false;
		} else {
			if(counter < numItems) {
			System.out.println(counter + " of your guesses are correct. Guess again.");
			return true;
		}
	}
		return false;
	
			
		
		
	}
}
