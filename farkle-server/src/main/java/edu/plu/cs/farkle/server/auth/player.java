package edu.plu.cs.farkle.server.auth;

public class player {
	
	private String name;
	private String pass;
	private int wins;
	
	public player(String user, String key){
		this.name = user;
		this.pass = key;
		wins = 0;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getWins() {
		return this.wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
}
