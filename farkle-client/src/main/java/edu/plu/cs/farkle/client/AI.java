package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class AI {

	private int difficulty;
	
	private Dice die;
	
	private String name;
	
	private ArrayList<Integer> diceRoll;
	
	//Constructor
	public AI(int d, String n){
		difficulty = d;
		name = n;
		die = new Dice();
	}

	//Picks best roll based on difficulty the player selected
	public void roll(){
		diceRoll = die.getRoll();
		for(int i = 0; i < diceRoll.size(); i++){
			
		}
		
	}
	
	private int bestRoll(int roll){
		int score = 0;
		
		for(int i = 0; i < difficulty; i++){
			
		}
		
		return score;
	}
	
}
