package edu.plu.cs.farkle.client;
import java.util.ArrayList;
import java.util.Stack;

public class Standard{
	
	protected int score = 0;
	protected int tempScore = 0;
	
	protected int oneScore = 0;

	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	
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
	
	
	public int bankScore(){
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
			
			if(single.get(i) == 1){
				bank += 100;
			}
			else if (single.get(i) == 5){
				bank += 50;
			}
		}
		
		if(nums[0] == 3){
			bank += 700;
		}

		for(int i = 1; i < nums.length; i++){
			if(nums[i]==3){
				bank += (i+1)*100;
			}
		}
		
		tempScore = bank;
		return bank;
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
