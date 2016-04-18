package edu.plu.cs.farkle.client;
import java.util.ArrayList;

public class Standard{
	
	protected int score = 0;
	protected int tempScore = 0;
	protected static ArrayList<Integer> set = new ArrayList<Integer>();
	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	public void debug(){
		//System.out.println("single: " + single);
		//System.out.println("set: " + set);
	}
	
	public void addToSingle(int value){
		single.add(value);
		//System.out.println("single: " + single);
	}
	
	public void addToSet(int value){
		set.add(value);
		//System.out.println("set: " + set);
	}
	
	public void removeFromSingle(int die){
		single.remove(Integer.valueOf(die));
		//System.out.println("single: " + single);
	}
	
	public void removeFromSet(int die){
		set.remove(Integer.valueOf(die));
		//System.out.println("set: " + set);
	}
	
	public void clear(){
		score = 0;
		set.clear();
		single.clear();
		System.out.println("set: " + set.toString() + "\nsingle: " + single.toString() + "\nScore: + " + score);
	}
	
	//calculate value of bank
	public void bank(){
		int bank = 0;
		
		//single calculation
		for (int i = 0; i < single.size(); i++){
			if (single.get(i) == 1){
				bank += 100;
				//single.remove(Integer.valueOf(1));
			}else if (single.get(i) == 5){
				bank += 50;
				//single.remove(Integer.valueOf(5));
			}
		}
		
		//set of 3 calc
		//Remember: Requires holding down shift to work
		if (set.size() == 3){
			boolean check1 = false;
			//Check dice 0-2 are equal
			for(int i=0; i<3; i++){
				if(set.get(0) == set.get(1)){
					if(set.get(1) == set.get(2)){
						check1 = true;
					}
				}
				else{
					check1 = false;
				}
			}
			
			if(check1){
				if (set.get(0) == 1){
					bank += 1000;
				}else{
					bank += set.get(0) * 100;
				}
				set.clear();
			}
		}
		
		/* This doesn't work yet, stil working on this...
		if(set.size() == 6){
			boolean checkA = false, checkB = false, checkC = false;
			
			//All 6 are the same, compare all together
			if(set.get(0) == set.get(3)){
				int comp = set.get(0);
				for(int i=1; i<6; i++){
					if(set.get(i) == comp){
						checkA = true;
					}
					else{
						checkA = false;
						break;
					}
				}
				
				if(checkA){
					if(set.get(0) == 1){
						bank += 2000;
					}
					else{
						bank += (set.get(0) * 100) * 2;
					}	
					set.clear();
				}
			}
			
			//Two sets of 3 check both sets
			for(int i=0; i<3; i++){
				if(set.get(0) == set.get(1)){
					if(set.get(1) == set.get(2)){
						checkB = true;
					}
				}
				else{
					checkB = false;
					break;
				}
			}
			for(int i=3; i<6; i++){
				if(set.get(3) == set.get(4)){
					if(set.get(4) == set.get(5)){
						checkC = true;
					}
				}
				else{
					checkC = false;
					break;
				}
			}
			
			if(checkB){
				if (set.get(0) == 1){
						bank += 1000;
					}else{
						bank += set.get(0) * 100;
					}
					set.clear();
			}
			if(checkC){
				if (set.get(3) == 1){
						bank += 1000;
					}else{
						bank += set.get(3) * 100;
					}
					set.clear();
			}
			
		}
		*/
		
		score += bank;
		tempScore = bank;
		
		single.clear();
	}
	
	public int getTemp(){
		return tempScore;
	}
	
	public int getScore(){
		return score;
	}


}
