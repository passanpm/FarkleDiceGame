package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public abstract class Gameplay {
	protected int score = 0;
	protected int tempScore = 0;
	protected int oneScore = 0;
	protected int[] nums;
	
	protected static ArrayList<Integer> single = new ArrayList<Integer>();
	
	boolean change = false;
	
	public abstract int bankScore();
	
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
	
	public void reset(){
		single.clear();
	}
	
	public int getTemp(){
		return tempScore;
	}
	
	public int getScore(){
		return score;
	}
	
	public boolean isChange(){
		return change;
	}
	

	
	
}
