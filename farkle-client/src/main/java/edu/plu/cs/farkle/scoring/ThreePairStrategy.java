package edu.plu.cs.farkle.scoring;

import java.util.ArrayList;

public class ThreePairStrategy extends ScoringRuleStrategy {

	@Override
	public int bankScore() {
		int tri = 0;
		
		//Iterate through and Count Pairs
		for(int i=0; i<6; i++){
			if(nums[i] == 2){
				tri++;
			}
		}
		
		if(tri == 3){
			change = true;
			return 1500;
		}
		else{
			change = false;
			return 0;
		}
	}

	@Override
	public int aiBankScore(ArrayList<Integer> aiRoll) {
		// TODO Auto-generated method stub
		return 0;
	}

}
