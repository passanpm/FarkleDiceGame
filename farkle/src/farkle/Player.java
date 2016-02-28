package farkle;

public class Player {
	
	public Player(){
		totalScore = 0;
		currentScore = 0;
	}

	private int totalScore;
	private int currentScore;
	
	public int getCurrent(){
		return currentScore;
	}
	
	public void setCurrent(int score){
		currentScore += score;	
	}
	
	public int getTotal(){
		return totalScore;
	}
	
	public void setTotal(int score){
		totalScore += score;
	}
	
}
