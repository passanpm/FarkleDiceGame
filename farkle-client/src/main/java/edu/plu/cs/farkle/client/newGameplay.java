package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class newGameplay extends Standard{
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
		
		
		

		for(int i = 1; i < nums.length; i++){
			if(nums[i]==3){
				if(i != 4){
					bank += (i+1)*100;
					change = true;
				}
			}
		}
		
		if( (nums[1] < 3 && nums[1] > 0) || (nums[2] < 3 && nums[2] > 0) || (nums[3] < 3 && nums[3] > 0) || (nums[5] < 3 && nums[5] > 0)){
			change = false;
		}
		
		tempScore = bank;
		
		return bank;
	}
	
	
}