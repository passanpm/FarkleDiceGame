package edu.plu.cs.farkle.server.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class redis {
	
	static Jedis jedis;
	
	public redis() {
	    jedis = new Jedis("pub-redis-14065.us-east-1-3.1.ec2.garantiadata.com", 14065);
	    jedis.auth("farkle");
	    System.out.println(" \n\nDatabase initiated");
	    
	}
	
	public boolean auth(player player){
		System.out.println("Attempting to authenticate...");
		if (jedis.exists(player.getName())){
			//listPlayers();
			//loadUser(player.getName());
			if (jedis.hgetAll(player.getName()).get("pass").equals(player.getPass())){
				System.out.println("Player password is authenticated");
				System.out.println(player.getName() + " exists in database");
				return true;
			}else{
				System.out.println("Player password is incorrect");
				return false;
			}
		}
		System.out.println("4");
		System.out.println(player.getName() + " does not exist in database");
		return false;
	}
	
	public String listPlayers(){
		ArrayList<player> pool = new ArrayList<player>();
		player p = new player();
		String thePlayers = "";
	    Set<String> names=jedis.keys("*");
	    System.out.println("PLAYERS: ");
	    Iterator<String> it = names.iterator();
	    
	    while (it.hasNext()) {
	        String s = it.next();
	        System.out.println(jedis.hget(s, "wins")+ ": " + s);
	        
	        thePlayers += jedis.hget(s, "wins") + " " + s + " ";
	    }
	    return thePlayers;
	    
	    
	    
	}
	
	public void removePlayer(String name){
	    jedis.del(name);
	    System.out.println("Removed " + name + " from Database");
	}
	
	public player addUser(player user) {
		Map<String, String> info = new HashMap<String, String>();
		player p = new player(user.getName(), user.getPass());
		 info.put("name", user.getName() );
		 info.put("pass", user.getPass());
		 info.put("wins", Integer.toString(user.getWins()));
		 info.put("total", Integer.toString(user.getTotal()));
		 
		 jedis.hmset(user.getName(), info);
		 System.out.println("Added " + p.getName() + " to Database");
		 return p;
		 
	}
	
	public player loadUser(String user){
	    Map<String, String> users = jedis.hgetAll(user);;
	    player p = new player(users.get("name"), users.get("pass"));
	    p.setName(user);
	    p.setWins(Integer.parseInt(users.get("wins")));
	    System.out.println("Welcome back " + users.get("name"));
	    System.out.println("Retrieved " + p.getName() + " from Database");
	    return p;
	}
	
	public void setWins(String s, String wins){
	    jedis.hset(s, "wins", wins);
	}
	
	public String getWins(player user){
		return (jedis.hget(user.getName(), "wins"));
	}
	
	public void setTotal(String s, String total){
	    jedis.hset(s, "total", total);
	}
	
	public String getTotal(player user){
		return (jedis.hget(user.getName(), "wins"));
	}
	
	public void setName(String string, String name){
	    jedis.hset(string, "name", name);
	}
	
	public String getName(String string){
		jedis.hset(string, "name", string);
		return jedis.hget(string, "name");
	}
	
	public void setPass(String string, String pass){
	    jedis.hset(string, "pass", pass);
	}
	
	public String getPass(String string){
		return (jedis.hget(string, "pass"));
	}
	
	
}
