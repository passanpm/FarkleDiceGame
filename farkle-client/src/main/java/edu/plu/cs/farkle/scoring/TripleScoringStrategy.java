package edu.plu.cs.farkle.scoring;

import java.util.ArrayList;

public class TripleScoringStrategy extends ScoringRuleStrategy {

	@Override
	public int bankScore() {
		//(to account for triples of different values)
		int tripleTotal = 0;
			
			//Iterate through and add to an external total 
			for(int i=0; i<6; i++){
				if(nums[i] == 3){
					change = true;
					if(i==0){
						tripleTotal += 1000;
					}
					else{
						tripleTotal += (i*100);
					}
				}
			}
			
		return tripleTotal;
	}

	@Override
	public int aiBankScore(ArrayList<Integer> aiRoll) {
		single = aiRoll;
		return this.bankScore();
	}

}
