package edu.plu.cs.farkle.client;
import java.util.ArrayList;

public class Standard{
	
	protected int score = 0;
	protected int tempScore = 0;
	protected int oneScore = 0;

	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	boolean change = false;
	
	/**
	 * Add a value of a dice to the single ArrayList to be banked
	 * @param value int face value of die to be added
	 */
	public void addToSingle(int value){
		single.add(value);
	}

	
	/**
	 * Remove a value of a dice from the ArrayList to be unbanked
	 * @param value int face value of die to be removed
	 */
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
	
	/**
	 * Clear all stored values of score and dice
	 */
	public void clear(){
		score = 0;
		single.clear();
	}
	
	/**
	 * Reset all values of game type to a new object
	 */
	public void reset(){
		single.clear();
	}
	
	
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
		
		if(nums[0] == 3){
			bank += 700;
		}
		
		if(nums[0] > 0 || nums[4] > 0)
			change = true;
		
		
		

		for(int i = 1; i < nums.length; i++){
			if(nums[i]==3){
				if(i == 4)
					bank += 350;
				else
					bank += (i+1)*100;
				change = true;
			}
		}
		
		if( (nums[1] < 3 && nums[1] > 0) || (nums[2] < 3 && nums[2] > 0) || (nums[3] < 3 && nums[3] > 0) || (nums[5] < 3 && nums[5] > 0)){
			change = false;
		}
		
		tempScore = bank;
		
		return bank;
	}
	
	
	/**
	 * Return the temporary value of the users score
	 * @return
	 */
	public int getTemp(){
		return tempScore;
	}
	
	/**
	 * Return the overall value of the users score
	 * @return
	 */
	public int getScore(){
		return score;
	}
	
	
	/**
	 * Return if the values stored in bank are valid
	 * @return
	 */
	public boolean isChange(){
		return change;
	}


}
