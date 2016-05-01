import edu.plu.cs.farkle.client.AI;

public class testAI {


	public static void main(String[] args) {
		AI hauser = new AI(1, "hauser");
		System.out.println("Hello, my name is " + hauser.getName() + " and my difficulty is " + hauser.getDifficulty());
		hauser.roll();
		
	}

}
