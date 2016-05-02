package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class AI extends Player{

	private int difficulty;
	
	private Dice die;
	
	private String name;
	
	private ArrayList<Integer> diceRoll;
	
	private ArrayList<Integer> diceScores;
	
	/**
	 * Constructor
	 * @param d the difficulty of the AI as an int
	 * @param n the name of the AI
	 */
	public AI(int d, String n){
		difficulty = d;
		name = n;
		die = new Dice();
		diceScores = new ArrayList<Integer>();
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
	public ArrayList<Integer> roll(){
		die.rollInit(6, 1, 6);
		diceRoll = die.getRoll();
		return diceRoll;
	}
	
	public ArrayList<Integer> getScore(){
		return diceScores;
	}
	/**
	 * Picks best roll and returns and int[] array
	 * Got help from here: http://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
	 * @return allIndexes the int array that contains the indexes of scoring die
	 */
	public int[] mergeIndexes(){
		int[] triple = setOfThrees();
		int[] singles = oneOrFive();
		int[] allIndexes = new int[triple.length + singles.length];
		try{
			System.arraycopy(triple, 0, allIndexes, 0, triple.length);
			System.arraycopy(singles, 0, allIndexes, triple.length, singles.length);
		} catch (Exception e){
			return null;
		}
		
		return allIndexes;
	}
	/**
	 * Checks to see if diceRoll has a set of threes and returns an array of the indexes of that set of three
	 * @return int[] index the array of indexes
	 */
	public int[] setOfThrees(){
		int[] index = new int[3];
		ArrayList<Integer> check = hasThree();
		System.out.println(check.toString());
		for(int i = 1; i <= 6; i++){
			if(check.contains(i)){
				int count = 0;
			for(int j = 0; j < diceRoll.size(); j++){
				if(diceRoll.get(j) == i){
					diceScores.add(i);
					index[count++] = j;
				}
				if(count > 2){
					break;
				}
			}
			break;
			}
		}
		return index;
	}
	
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
	
	private int[] oneOrFive(){
		int[] indexes = new int[6];
		int count = 0;
		for(int j = 0; j < diceRoll.size(); j++){
			if(diceRoll.get(j) == 1 || diceRoll.get(j) == 5){
				diceScores.add(diceRoll.get(j));
				indexes[count++] = j;
			}
			}
		return indexes;
	}
}
