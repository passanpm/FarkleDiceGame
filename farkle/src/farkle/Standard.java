package farkle;

public class Standard{
	
	//calculate value of bank
	public static void scoreBanking(int bank){
		
		//Standard rules for banking
		
		int bankScore = 0;
		Gameplay.updateScore(Gameplay.roller, bankScore);
		
	}
	
	//farkle
	public static void farkleRoll(){
		Gameplay.endTurn();
	}
	

}
