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
	 * Returns the name of the AI.
	 * @return the name of the AI
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns the difficulty of the AI
	 * @return the difficulty of the AI as an int
	 */
	public int getDifficulty(){
		return difficulty;
	}
	/**
	 * Rolls the dice and stores the result in diceRoll
	 */
	public void roll(){
		die.rollInit(6, 1, 6);
		diceRoll = die.getRoll();
		System.out.println(diceRoll.toString());
	}
	
	/**
	 * Picks best roll based on difficulty the player selected
	 * @return
	 */
	public int bestRoll(){
		int score = 0;
		
		for(int i = 0; i < diceRoll.size(); i++){
			
		}
		
		return score;
	}
	/**
	 * Checks to see if diceRoll has a set of threes and returns an array of the indexes of that set of three
	 * @return int[] index the array of indexes
	 */
	public int[] setOfThrees(){
		int[] index = {0, 0, 0};
		ArrayList<Integer> check = new ArrayList<Integer>();
		for(int i = 1; i <= 6; i++){
			check.add(i);
			check.add(i);
			check.add(i);
			boolean contains = diceRoll.containsAll(check); //this is returning true and it shouldn't
			if(contains){
				int count = 0;
			for(int j = 0; j < diceRoll.size(); j++){
				if(diceRoll.get(j) == i){
					index[count++] = j;
				}
				if(count > 2){
					break;
				}
			}
			break;
			}
			check.clear();
		}
		return index;
	}
}
