package farkle;

public class Standard{
	
	int score = 0;
	int[] set = new int[6];
	int[] single = new int[6];
	
	public void addToSingle(int die, int value){
		single[die] = value;
	}
	
	public void addToSet(int die, int value){
		single[die] = value;
	}
	
	public void removeFromSingle(int die){
		single[die]=0;
	}
	
	public void removeFromSet(int die){
		set[die]=0;
	}
	
	//calculate value of bank
	public void bank(){
		int bank = 0;
		
		for (int i = 0; i < 6; i++){
			if (single[i] == 1){
				bank += 100;
				single[i] = 0;
			}else if (single[i] == 5){
				bank += 50;
				single[i] = 0;
			}
		}
		
		score += bank;
		
		System.out.println(bank);
		
	}
	
	public int getScore(){
		return score;
	}
	
	//farkle -> next player
	public static void farkle(){
		if (Gameplay.roller < Gameplay.players.size()-1){
			Gameplay.roller++;
		}else{
			Gameplay.roller = 0;
		};
	}
	

}
