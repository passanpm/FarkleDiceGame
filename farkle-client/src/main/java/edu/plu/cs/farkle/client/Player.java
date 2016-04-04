package edu.plu.cs.farkle.client;
public class Player {
	
	String name;
	String pass;
	private int totalScore;
	private int currentScore;
	
	public Player(String user, String key){
		this.name = user;
		this.pass = key;
		totalScore = 0;
		currentScore = 0;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}
	
	
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
