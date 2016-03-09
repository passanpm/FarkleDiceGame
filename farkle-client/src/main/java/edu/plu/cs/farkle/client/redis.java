package edu.plu.cs.farkle.client;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class redis {
	
	static Jedis jedis;
	
	void initiateServer() {
	    jedis = new Jedis("pub-redis-14065.us-east-1-3.1.ec2.garantiadata.com", 14065);
	    jedis.auth("farkle");
	    System.out.println("Connected to Redis");
	    
	}
	
	void addUser(Player user) {
		Map<String, String> players = new HashMap<String, String>();
		 players.put("name", user.getName() );
		 players.put("current", Integer.toString(user.getCurrent()));
		 players.put("highScore", Integer.toString(user.getTotal()));
		 
	}
	
	void loadUser(Player user){
	    Map<String, String> properties = jedis.hgetAll("user:" + user.getName());
	    
	}
	
}
