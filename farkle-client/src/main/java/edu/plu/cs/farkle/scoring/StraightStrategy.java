package edu.plu.cs.farkle.scoring;

import java.util.ArrayList;

public class StraightStrategy extends ScoringRuleStrategy {

	@Override
	public int bankScore() {
		if(nums[0] == 1 && nums[1] == 1 && nums[2] == 1  && nums[3] == 1 && nums[4] == 1 && nums[5] == 1 ){
			change = true;
			return 2500;
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
