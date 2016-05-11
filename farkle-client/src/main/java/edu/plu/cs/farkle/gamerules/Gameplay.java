package edu.plu.cs.farkle.gamerules;

import java.util.ArrayList;

public abstract class Gameplay {
	protected int score = 0;
	protected int tempScore = 0;
	protected int oneScore = 0;
	protected int[] nums;
	
	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	boolean change = false;
	
	public abstract int bankScore();
	
	public abstract int aiBankScore(ArrayList<Integer> aiRoll);
	
	public void addToSingle(int value){
		single.add(value);
	}

	public void removeFromSingle(int die){
		boolean found = false;
		int i = 0;
		while(!found){
			if(single.get(i)*-1==die){
				single.remove(i);
				found = true;
			}
			else
				i++;
		}
	}
	
	public void clear(){
		score = 0;
		single.clear();
	}
	
	public void reset(){
		single.clear();
	}
	
	public int getTemp(){
		return tempScore;
	}
	
	public int getScore(){
		return score;
	}
	
	public boolean isChange(){
		return change;
	}
	
	public void countDice(){
		nums = new int[6];
		
		//Clear the array
		for(int i = 0; i < nums.length; i++)
			nums[i] = 0;
		
		//Find how many of each value have been selected
		for(int i = 0; i < single.size(); i++){
			switch(single.get(i)){
				case 1:
					nums[0] += 1;
					break;
				case 2:
					nums[1] += 1;
					break;
				case 3:
					nums[2] += 1;
					break;
				case 4:
					nums[3] += 1;
					break;
				case 5: 
					nums[4] += 1;
					break;
				case 6: 
					nums[5] += 1;
					break;
			}
		}
	}
	
}
