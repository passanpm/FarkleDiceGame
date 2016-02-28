package farkle;

import java.util.ArrayList;

public class Standard{
	
	int score = 0;
	ArrayList<Integer> set = new ArrayList<Integer>();
	ArrayList<Integer> single = new ArrayList<Integer>();
	
	public void addToSingle(int value){
		single.add(value);
	}
	
	public void addToSet(int value){
		set.add(value);
	}
	
	public void removeFromSingle(int die){
		single.remove(single.size()-1);
	}
	
	public void removeFromSet(int die){
		set.remove(single.size()-1);
	}
	
	//calculate value of bank
	public void bank(){
		int bank = 0;
		
		//single calculation
		for (int i = 0; i < single.size(); i++){
			if (single.get(i) == 1){
				bank += 100;
				single.set(i, 0);
			}else if (single.get(i) == 5){
				bank += 50;
				single.set(i, 0);
			}
		}
		
		//set of 3 calc
		if (set.size() == 3){
			bank += set.get(0) * 100;
			set.clear();
		}
		if (set.size() == 6){
			bank += set.get(0) * 100;
			bank += set.get(3) * 100;
			set.clear();
		}
		
		
		score += bank;
		
		
		
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
