package edu.plu.cs.farkle.scoring;

import java.util.ArrayList;

public class FullHouseStrategy extends ScoringRuleStrategy {

	@Override
	public int bankScore() {
		boolean two = false, three = false;
		int threeMark = 0;
		
		for(int i=0; i<6; i++){
			if(nums[i] == 3){
				three = true;
				threeMark = i;
			}
			else if(nums[i] == 2){
				two = true;
			}
		}
		
		if(two && three){
			change = true;
			if(threeMark == 0){
				return 1250;
			}
			else{
				return (threeMark*100)+250;
			}
		}
		else{
			change = false;
			return 0;
		}
	}

	@Override
	public int aiBankScore(ArrayList<Integer> aiRoll) {
		single = aiRoll;
		return this.bankScore();
	}

}
