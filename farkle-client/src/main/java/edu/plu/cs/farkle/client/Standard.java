package edu.plu.cs.farkle.client;
import java.util.ArrayList;

public class Standard{
	
	protected int score = 0;
	protected int tempScore = 0;
	
	protected int oneScore = 0;
	
	protected static ArrayList<Integer> set = new ArrayList<Integer>();
	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	public void addToSingle(int value){
		single.add(value);
	}
	
	public void addToSet(int value){
		set.add(value);
	}
	
	public void removeFromSingle(int die){
		System.out.println("Single: " + single.toString());
		single.remove(Integer.valueOf(die));
	}
	
	public void removeFromSet(int die){
		set.remove(Integer.valueOf(die));
	}
	
	public void clear(){
		score = 0;
		set.clear();
		single.clear();
	}
	
	//calculate value of bank
	public void bank(){
		int bank = 0;
		oneScore = 0;
		boolean check, check1;
		
		//single calculation
		for (int i = 0; i < single.size(); i++){
			if (single.get(i) == 1){
				bank += 100;
				oneScore = 100;
			}else if (single.get(i) == 5){
				bank += 50;
				oneScore = 50;
			}
			if(single.get(i) != 1 && single.get(i) != 5)
				bank = 0;
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
	
	public int getOne(){
		return oneScore;
	}


}
