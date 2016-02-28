package farkle;

public class Standard extends Gameplay{
	
	//calculate value of bank
	public void bank(int[] dice){
		
		//updates score of current roller
		for (int i = 0; i<6; i++){
			
			if (dice[i+1] != dice[i]){
				if (i == 0){
					rollerScore += 100;
				}else if (i == 4){
					rollerScore += 50;
				}
			}
			
			
		}
		
		
		
		
	}
	
	//farkle -> next player
	public static void farkle(){
		if (roller < players.size()-1){
			roller++;
		}else{
			roller = 0;
		};
	}
	

}
