package farkle;
import java.util.Random;

public class Dice {

	private static int[] roll = new int[6];
	private static int[] bank = new int[6];
	
	
	/*
	 * Will look in the roll array for a farkle. If there is a farkle found, it will return
	 * true. If not, the player will be able to keep rolling.
	 * 
	 * The "definition" of farkle is determined by game rules
	 */
	public static boolean farkle(){
		
		boolean farkle = false;
		
		if(farkle)
			resetDice();
		
		return farkle;
	}
	
	/*
	 * initializes dice arrays back to 0
	 */
	public static void resetDice(){
		for(int i = 0; i < roll.length; i++){
			for(int j = 0; j < bank.length; j++){
				roll[i] = 0;
				bank [j] = 0;
			}
		}
	}
	
	/*
	 * This will roll the dice and store them into the roll array.
	 * @param dieMax The max value of the dice (Example is a 6-sided dice would be 6)
	 * @param dieMin The min value of the dice (Will almost always be 1)
	 * @param amount The amount of dice that are being rolled
	 * 
	 * TODO: Add in animations and other UI things for when the dice roll
	 */
	public void roll(int dieMax, int dieMin, int amount){
		Random r = new Random();
		int randomNumber = 0;
		for(int i = 0; i < amount; i++){
			randomNumber = r.nextInt((dieMax - dieMin) + 1) + dieMin;
			roll[i] = randomNumber;
		}
	
	}
	
	
	public int[] getRoll(){
		return roll;
	}
	
	/*
	 * Allows the player to select dice to add/remove to the banking area 
	 * in a given turn.
	 */
	public void banking(int die, int value){
		
		/*
		 * if the dice is clicked...
		 * Add the dice to bank array.
		*/
		bank[die] = value;
		System.out.println("DEBUG bank["+die+"] = "+ bank[die]);
		/*
		 * if the dice that is banked in the same turn is clicked again...
		 * Remove the dice from bank array and add back to roll array
		 */
	}
	
	
	
	public void unBank(int die){
		bank[die]=0;
		System.out.println("DEBUG unBank["+die+"] = "+ bank[die]);
	}
	
}
