package edu.plu.cs.farkle.server.auth;

public class player {
	
	private String name;
	private String pass;
	private String players;

	private int wins;
	private int total;
	
	public player(String user, String key){
		this.name = user;
		this.pass = key;
		wins = 0;
		total = 0;
	}
	
	public player(){
		this.name = "null";
		this.pass = "null";
		wins = 0;
		total = 0;
	}
	
	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
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


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	
}
