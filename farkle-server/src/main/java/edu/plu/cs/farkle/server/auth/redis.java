package edu.plu.cs.farkle.server.auth;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class redis {
	
	static Jedis jedis;
	
	public void initiateServer() {
	    jedis = new Jedis("pub-redis-14065.us-east-1-3.1.ec2.garantiadata.com", 14065);
	    jedis.auth("farkle");
	    System.out.println("Database initiated");
	    
	}
	
	public boolean auth(player player){
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
		return false;
	}
	
	public void listPlayers(){
	    Set<String> names=jedis.keys("*");
	    int count = 1;
	    System.out.println("PLAYERS: ");
	    Iterator<String> it = names.iterator();
	    while (it.hasNext()) {
	        String s = it.next();
	        System.out.println(count + ": " + s);
	        count ++;
	    }
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
		 info.put("current", Integer.toString(user.getCurrent()));
		 info.put("total", Integer.toString(user.getTotal()));
		 
		 jedis.hmset(user.getName(), info);
		 System.out.println("Added " + p.getName() + " to Database");
		 return p;
		 
	}
	
	public player loadUser(String user){
	    Map<String, String> users = jedis.hgetAll(user);;
	    player p = new player(users.get("name"), users.get("pass"));
	    p.setName(user);
	    p.setCurrent(Integer.parseInt(users.get("current")));
	    p.setTotal(Integer.parseInt(users.get("total")));
	    System.out.println("Welcome back " + users.get("name"));
	    System.out.println("Retrieved " + p.getName() + " from Database");
	    return p;
	}
	
	public void updateCurrent(player user){
	    jedis.hset(user.getName(), "current", Integer.toString(user.getCurrent()));
	}
	
	public String getCurrent(player user){
		return (jedis.hget(user.getName(), "current"));
	}
	
	public void updateTotal(player user){
	    jedis.hset(user.getName(), "total", Integer.toString(user.getTotal()));
	}
	
	public int getTotal(player user){
		return Integer.parseInt(jedis.hget(user.getName(), "total"));
	}
	
	
}
