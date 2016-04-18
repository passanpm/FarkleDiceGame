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
		boolean check, check1;
		
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
			check = checkSet(0,2);
			
			if(check){
				if (set.get(0) == 1){
					bank += 1000;
				}else{
					bank += set.get(0) * 100;
				}
				set.clear();
			}
		}
		
		//set of 6 calculation
		//Remember: Requires holding down shift
		if (set.size() == 6){
			check = checkSet(0,2);
			check1 = checkSet(3,5);
			
			if(check && check1){
				if(set.get(0) == set.get(3)){
					if(set.get(0) == 1){
						bank += 2000;
					}
					else{
						bank += (set.get(0) * 100) * 2;
					}
					set.clear();
				}
				else{
					if (set.get(0) == 1){
						bank += 1000;
					}else{
						bank += set.get(0) * 100;
					}
					if (set.get(3) == 1){
						bank += 1000;
					}else{
						bank += set.get(3) * 100;
					}
					set.clear();
				}
			}
		}
		
		score += bank;
		tempScore = bank;
		
		single.clear();
	}
	
	private boolean checkSet(int start, int end){
		boolean check = false;
		for(int i=start; i<end; i++){
			if(set.get(start) == set.get(start+1)){
				if(set.get(start+1) == set.get(end)){
					check = true;
				}
			}
			else{
				check = false;
			}
		}
		return check;
	}
	
	public int getTemp(){
		return tempScore;
	}
	
	public int getScore(){
		return score;
	}


}
