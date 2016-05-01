package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class AI {

	private int difficulty;
	
	private Dice die;
	
	private String name;
	
	private ArrayList<Integer> diceRoll;
	
	/**
	 * Constructor
	 * @param d the difficulty of the AI as an int
	 * @param n the name of the AI
	 */
	public AI(int d, String n){
		difficulty = d;
		name = n;
		die = new Dice();
	}

	/**
	 * Rolls the dice and stores the result in diceRoll
	 */
	public void roll(){
		diceRoll = die.getRoll();
	}
	
	/**
	 * Picks best roll based on difficulty the player selected
	 * @return
	 */
	private int bestRoll(){
		int score = 0;
		
		for(int i = 0; i < diceRoll.size(); i++){
			
		}
		
		return score;
	}
	/**
	 * Checks to see if diceRoll has a set of threes and returns an array of the indexes of that set of three
	 * @return int[] index the array of indexes
	 */
	private int[] setOfThrees(){
		int[] index = new int[3];
		ArrayList<Integer> check = new ArrayList<Integer>();
		for(int i = 0; i< 6; i++){
			check.add(i);
			check.add(i);
			check.add(i);
			for(int j = 0; j < diceRoll.size(); j++){
				if(diceRoll.containsAll(check)){
					
				}
			}
		}
		return index;
	}
}
