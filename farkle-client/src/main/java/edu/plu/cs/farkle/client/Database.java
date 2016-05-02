package edu.plu.cs.farkle.client;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import jdk.nashorn.internal.parser.JSONParser;

public class Database {



	static Player user = new Player();
	String username = "user";
	String password = "pass";

	public static void main(String[] args){
		Database d = new Database("jon", "pass");
		System.out.println(1);
		//d.get();
		
		
		System.out.println(2);
		d.put();
		
		System.out.println(3);
		d.get();
		
		System.out.println("NUMBER OF PLAYERS: " + user.getPlayers().size());
		
		
		System.out.println(4);
		user.setName("NEWNAME");
		user.setPass("NEWPASS");
		user.setTotal(500);
		user.setWins(5);
		
		d.post();
		
		System.out.println(5);
		d.get();
		System.out.println("NUMBER OF PLAYERS: " + user.getPlayers().size());
		System.out.println(6);
		d.delete();
		
		System.out.println(7);
		d.get();
		
		
		

	}

	public Database(String username, String password) {
			this.username = username;
			this.password = password;
	}

	public void put(){
		init("put");
	}
	public boolean get(){
		return init("get");
	}
	public void delete(){
		init("delete");
	}
	public void post(){
		init("post");
	}
	
	public boolean init(String action){
		
		Client client = null;
		try {
			client = ClientBuilder.newClient();


			ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget)client.target("http://localhost:8080/farkle/crud");
			resteasyWebTarget.register(new BasicAuthentication(username, password));

			Entity<Player> u = Entity.json(user);
			
			Invocation.Builder builder = resteasyWebTarget.request();
			String r = builder.get(String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(r);
			
			
			switch (action){
				case "put":
					try {
						//call put
						resteasyWebTarget.request().put(u);
						
						//debug
						System.out.println("PUT: " + username);
						return true;
					} catch (Exception e) {
						return false;
					}
					
				case "delete":
					try {
						//call delete
						resteasyWebTarget.request().delete();
						
						//debug
						System.out.println("DELETE: " + user.getName());
						user = new Player();
						return true;
					} catch (Exception e) {
						return false;
					}
					
				case "post":
					//debug
					System.out.println("POST: " + user.getName());
					
					
					//build json with new data from player
					((ObjectNode)node).put("name", user.getName());
					((ObjectNode)node).put("pass", user.getPass());
					((ObjectNode)node).put("wins", Integer.toString(user.getWins()));
					((ObjectNode)node).put("total", Integer.toString(user.getTotal()));
					
					
					resteasyWebTarget.request().post(u);
					
					username = user.getName();
					password = user.getPass();
					//debug
					System.out.println(node.toString());	
					break;	
					
				case "get":
					
					try {
						//call get
						if (resteasyWebTarget.request().get().equals("null")){
							System.out.println("GET: Player does not exist");
							return false;
						}
						
						
						//update player class
						user.setName(node.get("name").asText());
						user.setPass(node.get("pass").asText());
						user.setTotal(Integer.parseInt(node.get("total").asText()));
						user.setWins(Integer.parseInt(node.get("wins").asText()));
						user.setPlayers(node.get("players").asText());
						
						
						//debug
						System.out.println("GET: " + node.get("name"));
						System.out.println(node.toString());
						return true;
					} catch (Exception e) {
						System.out.println("Player does not exist");
						return false;
					}
					
			}
			
		} catch (Exception e) {
		}
		client.close();
		return false;
	}
	
	

	
	

}
