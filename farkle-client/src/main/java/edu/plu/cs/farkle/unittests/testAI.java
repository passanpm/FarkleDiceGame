package edu.plu.cs.farkle.unittests;
//import edu.plu.cs.farkle.client.AI;

import edu.plu.cs.farkle.client.AI;

public class testAI {

	public static void main(String[] args) {
		
		AI a = new AI(1, "Boot Loop");
		
		System.out.println("Hello, my name is " + a.getName() + " and my difficulty is " + a.getDifficulty());
		
		
		System.out.println("Indexes: " + a.getIndexes().toString());
		
		System.out.println("Scoring Dice: " + a.getScore().toString());
	}
	
	
}
