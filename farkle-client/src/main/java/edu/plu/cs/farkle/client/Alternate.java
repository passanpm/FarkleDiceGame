package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class Alternate extends Standard{
	protected int score = 0;
	protected int tempScore = 0;
	protected int oneScore = 0;

	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	boolean change = false;
	
	/**
	 * Calculate the score of banked dice
	 * @return the value of the scoring banked dice
	 */
	public int bankScore(){
		change = false;
		
		int bank = 0;
		int[] nums = new int[6];
		
		for(int i = 0; i < nums.length; i++)
			nums[i] = 0;
		
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
			
			if(single.get(i) == 1)
				bank += 100;			
			else if (single.get(i) == 5)
				bank += 50;
			
		}
		//There is a set of dice with value 1
		if(nums[0] == 3){
			bank += 700;
		}
		
		//There is a set of dice with value 5
		if(nums[4] == 3){
			bank += 350;
		}
		
		if(nums[0] > 0 || nums[4] > 0)
			change = true;

		
		int threePair = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i]==3){
				if(i != 4){
					bank += (i+1)*100;
					change = true;
				}
			}
			//added for Full House
			if(nums[i]==2){
				bank+= 250;
				threePair += 1;
				change = true;
				//if there have been three pairs add score
				if(threePair == 3){
					bank += 1500;
					change = true;
				}
			}
			//four of a kind
			if(nums[i]==4){
				bank += 2000;
				change = true;
			}
			//five of a kind
			if(nums[i]==5){
				bank += 4000;
				change = true;
			}
			//six of a kind
			if(nums[i] == 6){
				bank += 6000;
				change = true;
			}
			
		}
		
		//Straight Calculation
		if(nums[0] == 1 && nums[1] == 1 && nums[2] == 1  && nums[3] == 1 && nums[4] == 1 && nums[5] == 1 ){
			bank += 2500;
			change = true;
		}
		
		//no scoring dice automatic 500
		if( (nums[1] < 3 && nums[1] > 0) && (nums[2] < 3 && nums[2] > 0) && (nums[3] < 3 && nums[3] > 0) && (nums[5] < 3 && nums[5] > 0)){
			bank += 500;
			change = true;
		}
		
		
		//farkle check
		if( (nums[1] < 3 && nums[1] > 0) || (nums[2] < 3 && nums[2] > 0) || (nums[3] < 3 && nums[3] > 0) || (nums[5] < 3 && nums[5] > 0)){
			change = false;
		}
		
		tempScore = bank;
		return bank;
	}
	
	/*
	 * Unsure if this will be needed, but it's here just in case.
	
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
	
	*/
}