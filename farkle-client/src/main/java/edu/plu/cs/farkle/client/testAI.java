package edu.plu.cs.farkle.client;
import edu.plu.cs.farkle.client.AI;

public class testAI {


	public static void main(String[] args) {
		AI a = new AI(1, "Boot Loop");
		System.out.println("Hello, my name is " + a.getName() + " and my difficulty is " + a.getDifficulty());
		//a.roll();
		System.out.println(a.roll().toString());
		int[] indices = new int[6];
		indices = a.mergeIndexes();
		
		for(int i = 0; i< indices.length; i++)
			System.out.print(indices[i] + ",");
		
		System.out.println("\n" + a.getScore().toString());
	}
	
	
}
