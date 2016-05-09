package edu.plu.cs.farkle.client;
import java.util.ArrayList;

public class Standard extends Gameplay{
	
	public int bankScore(){
		change = false;
		
		int bank = 0;
		countDice();
		
		int amt;
		//Add 100 for each 1
		if(nums[0]>0){
			amt = nums[0];
			bank += 100*amt;
			System.out.println(amt+" 1's - Added "+100*amt);
		}
		
		//Add 50 for each 5
		if(nums[4]>0){
			amt = nums[4];
			bank += 50*amt;
			System.out.println(amt+" 5's - Added "+50*amt);
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
	
	public int aiBankScore(ArrayList<Integer> aiRoll){
		single = aiRoll;
		return bankScore();
	}

}
