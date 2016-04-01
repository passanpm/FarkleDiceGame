package edu.plu.cs.farkle.client;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Dice{

	private static ArrayList<Integer> roll = new ArrayList<Integer>();
	private static int[] bank = new int[6];
	
	
	/*
	 * Will look in the roll array for a farkle. If there is a farkle found, it will return
	 * true. If not, the player will be able to keep rolling.
	 * 
	 * The "definition" of farkle is determined by game rules
	 */
	public boolean farkle(){
		
		for(int i = 0; i < roll.size(); i++){
			
			if(roll.get(i)==1||roll.get(i)==5){
				return false;
			}
			
			for(int j = roll.size()-3; j > i; j--){
				
				for(int k = roll.size()-1; k>j; k--){
					
					if( roll.get(i) == roll.get(j) && roll.get(i) == roll.get(k) && roll.get(i)>0 && roll.get(j) > 0 && roll.get(k) > 0){
					
						return false;
					}
					
				}
					
				
			}
				
		}
		
		return true;
	}
	
	/*
	 * initializes dice arrays back to 0
	 */
	public static void resetDice(){
		for(int i = 0; i < roll.size(); i++){
			for(int j = 0; j < bank.length; j++){
				roll.add(i,0);
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
	public void roll(int dieMax, int dieMin, ArrayList<Integer> amount){
		//roll.clear();
		roll = amount;
		Random r = new Random();
		int randomNumber = 0;
		for(int i = 0; i < amount.size(); i++){
			randomNumber = r.nextInt((dieMax - dieMin) + 1) + dieMin;
			if(amount.get(i)>=0)
				roll.set(i,randomNumber);
		}
	
	}
	
	
	public void rollInit(int dieMax, int dieMin, int amount){
		roll.clear();
		Random r = new Random();
		int randomNumber = 0;
		for(int i = 0; i < amount; i++){
			randomNumber = r.nextInt((dieMax - dieMin) + 1) + dieMin;
			roll.add(i,randomNumber);
		}
	
	}
	/*
	 * 
	 */
	public ArrayList<Integer> getRoll(){
		System.out.println("ROLL: " + roll.toString());
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
		roll.set(die,value*-1);
		System.out.println("Die: " +die);
		System.out.println("DEBUG bank["+die+"] = "+ bank[die]);
		System.out.println("DEBUG roll: "+roll.toString());
		
		/*
		 * if the dice that is banked in the same turn is clicked again...
		 * Remove the dice from bank array and add back to roll array
		 */
	}
	
	/*
	 * 
	 */
	public void unBank(int die, int value){
		roll.set(die, value*-1);
		System.out.println("Die: " +die);
		bank[die]=0;
		
		System.out.println("DEBUG bank["+die+"] = "+ bank[die]);
		System.out.println("DEBUG roll: "+roll.toString());
		//System.out.println("DEBUG unBank["+die+"] = "+ bank[die]);
	}
	
}
