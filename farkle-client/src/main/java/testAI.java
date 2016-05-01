import edu.plu.cs.farkle.client.AI;

public class testAI {


	public static void main(String[] args) {
		AI hauser = new AI(1, "hauser");
		System.out.println("Hello, my name is " + hauser.getName() + " and my difficulty is " + hauser.getDifficulty());
		hauser.roll();
		
		int[] indices = new int[3];
		indices = hauser.setOfThrees();
		
		for(int i = 0; i< indices.length; i++)
			System.out.print(indices[i] + ",");
	}

}
