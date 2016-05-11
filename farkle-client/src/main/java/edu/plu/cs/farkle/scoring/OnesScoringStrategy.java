package edu.plu.cs.farkle.scoring;

import java.util.ArrayList;

public class OnesScoringStrategy extends ScoringRuleStrategy{

	@Override
	public int bankScore() {
		int onesAmt = nums[0];
		/*
		if(onesAmt == 3){
			change = true;
			return 1000;
		}
		*/
		if(onesAmt > 0 && onesAmt != 3){
			change = true;
			return (onesAmt * 100);
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
