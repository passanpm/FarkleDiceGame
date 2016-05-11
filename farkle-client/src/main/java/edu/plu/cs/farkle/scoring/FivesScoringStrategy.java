package edu.plu.cs.farkle.scoring;

import java.util.ArrayList;

public class FivesScoringStrategy extends ScoringRuleStrategy {

	@Override
	public int bankScore() {	
		int fivesAmt = nums[4];
		/*
		if(fivesAmt == 3){
			change = true;
			return 500;
		}
		*/
		if(fivesAmt > 0 && fivesAmt != 3){
			change = true;
			return (fivesAmt * 50);
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
