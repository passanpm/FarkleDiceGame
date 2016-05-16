package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class AI extends Player{
	//the difficulty of the AI as an int
	private int difficulty;
	

	//the name of the AI as a String
	private String name;
	//all the values of the dice rolled
	private ArrayList<Integer> diceRoll;
	//the values of all the scoring dice
	private ArrayList<Integer> diceScores;
	//the indexes of all the scoring dice
	private ArrayList<Integer> indexesOfAllScoringDice;
	/**
	 * Constructor
	 * @param d the difficulty of the AI as an int
	 * @param n the name of the AI
	 */
	public AI(int d, String n){
		difficulty = d;
		name = n;
		diceScores = new ArrayList<Integer>();
		indexesOfAllScoringDice = new ArrayList<Integer>();
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
	
	public void setRoll(ArrayList<Integer> thisDice){
		diceRoll = thisDice;
	}
	/**
	 * Rolls the dice and stores the result in diceRoll
	 * @return
	 */

	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getScore(){
		System.out.println("DIceRoll: " + diceRoll.toString());
		return diceScores;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getIndexes(){
		setOfThrees();
		oneOrFive();
		return indexesOfAllScoringDice;
	}
	/**
	 * Checks to see if diceRoll has a set of threes and returns an array of the indexes of that set of three
	 * @return int[] index the array of indexes
	 */
	public void setOfThrees(){
		ArrayList<Integer> check = hasThree();
		for(int i = 1; i <= 6; i++){
			if(check.contains(i)){
				int count = 0;
			for(int j = 0; j < diceRoll.size(); j++){
				if(diceRoll.get(j) == i){
					diceScores.add(i);
					indexesOfAllScoringDice.add(j);
				}
				if(count > 2){
					break;
				}
			}
			break;
			}
		}
	}
	/**
	 * Looks for a triple and returns the values in an ArrayList<Integer>
	 * @return
	 */
	private ArrayList<Integer> hasThree(){
		ArrayList<Integer> diceNumbers = new ArrayList<Integer>();
		int count = 0;
		for(int i = 1; i<= 6; i++){
			for(int j = 0; j < diceRoll.size(); j++){
				if( diceRoll.get(j) == i){
					count++;
				}
				if(count == 3){
					 diceNumbers.add(i);
					 break;
				}
			}
			count = 0;
		}
		return diceNumbers;
	}
	/**
	 * Looks for a one or a five and stores the indexes in indexesOfAllScoringDice
	 * and the values in diceScores
	 */
	private void oneOrFive(){
		for(int j = 0; j < diceRoll.size(); j++){
			if(diceRoll.get(j) == 1 || diceRoll.get(j) == 5){
				diceScores.add(diceRoll.get(j));
				indexesOfAllScoringDice.add(j);
			}
			}
	}
}
