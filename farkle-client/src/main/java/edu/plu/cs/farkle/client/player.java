package edu.plu.cs.farkle.client;
public class player {

	private String name;
	private String pass;
	private int totalScore;
	private int currentScore;
	
	public player(){
		name = "user";
		pass = "pass";
		totalScore = 0;
		currentScore = 0;
	}
	
	public player(String user, String key){
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

	
	public int getTotal(){
		return totalScore;
	}
	
	public void setTotal(int score){
		totalScore += score;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getCurrent() {
		return this.currentScore;
	}
	
	public void setCurrent(int current) {
		this.currentScore = current;
	}
	
}
