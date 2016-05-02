package edu.plu.cs.farkle.client;
import edu.plu.cs.farkle.client.AI;

public class testAI {


	public static void main(String[] args) {
		AI a = new AI(1, "Boot Loop");
		System.out.println("Hello, my name is " + a.getName() + " and my difficulty is " + a.getDifficulty());
		a.roll();
		
		int[] indices = new int[3];
		indices = a.setOfThrees();
		
		for(int i = 0; i< indices.length; i++)
			System.out.print(indices[i] + ",");
	}

}
