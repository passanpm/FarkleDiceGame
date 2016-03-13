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
	
	public Player auth(Player player){
		if (jedis.exists(player.getName())){
			return loadUser(player.getName());
		}else{
			return addUser(player);
		}
	}
	
	public Player addUser(Player user) {
		Map<String, String> info = new HashMap<String, String>();
		Player p = new Player();
		 info.put("name", user.getName() );
		 info.put("current", Integer.toString(user.getCurrent()));
		 info.put("total", Integer.toString(user.getTotal()));
		 
		 jedis.hmset(user.getName(), info);
		 System.out.println("Welcome " + info.get("name"));
		 return p;
		 
	}
	
	public Player loadUser(String user){
	    Map<String, String> users = jedis.hgetAll(user);
	    Player p = new Player();
	    p.setName(user);
	    p.setCurrent(Integer.parseInt(users.get("current")));
	    p.setTotal(Integer.parseInt(users.get("total")));
	    System.out.println("Welcome back " + users.get("name"));
	    return p;
	}
	
	public void updateCurrent(Player user){
	    jedis.hset(user.getName(), "current", Integer.toString(user.getCurrent()));
	    System.out.println("current: " + user.getCurrent());
	}
	
	public void updateTotal(Player user){
	    jedis.hset(user.getName(), "total", Integer.toString(user.getTotal()));
	    System.out.println("current: " + user.getTotal());
	}
	
	
}
