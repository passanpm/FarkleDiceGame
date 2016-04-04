package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class AI {

	private int difficulty;
	
	private Dice die;
	
	private ArrayList<Integer> diceRoll;
	
	//Constructor
	public AI(int d){
		difficulty = d;
		die = new Dice();
	}

	//Picks best roll based on difficulty the player selected
	public void roll(){
		diceRoll = die.getRoll();
		
		
	}
	
	
	private int bestRoll(int roll){
		int score = 0;
		
		return score;
	}
	
}
