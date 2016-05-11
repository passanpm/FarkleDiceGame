package edu.plu.cs.farkle.scoring;

import java.util.ArrayList;

public class CompositeStrategy extends ScoringRuleStrategy {
	ArrayList<ScoringRuleStrategy> rules = new ArrayList<ScoringRuleStrategy>();
	
	@Override
	public int bankScore() {
		int score = 0;
		
		for(ScoringRuleStrategy given : rules){
			score += given.bankScore();
		}
		return score;
	}

	@Override
	public int aiBankScore(ArrayList<Integer> aiRoll) {
		single = aiRoll;
		return this.bankScore();
	}
	
	
	public void add(ScoringRuleStrategy rule){
		rules.add(rule);
	}
}
