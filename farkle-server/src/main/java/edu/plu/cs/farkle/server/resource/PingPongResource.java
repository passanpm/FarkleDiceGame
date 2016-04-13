package edu.plu.cs.farkle.server.resource;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;

import edu.plu.cs.farkle.server.auth.player;
import edu.plu.cs.farkle.server.auth.redis;

/**
 * This is a simple example, not intended for use in the final product.
 * 
 * Responds with a JSON "pong" when requested via GET
 */
@Path("/ping")
public class PingPongResource {
	
	
	/**
	 * Returns a JSON object with two fields, "response" and "authenticated".
	 * 
	 * The "response" field is the string "pong".
	 * The "authenticated" filed is "yes" or "no" indicating whether or not this request
	 * was authenticated by the AuthenticatorFilter.
	 * 
	 * @param ctx the security context
	 * @return the JSON object
	 */
	@GET
	@Produces("application/json")
	public boolean getPing(@Context SecurityContext ctx ) {
		
		// If the principal is null, then authentication failed.
		String authString = "yes";
		if( ctx.getUserPrincipal() == null ) {
			authString = "no";
			return false;
		}
		
		 //Split username and password tokens
        final StringTokenizer tokenizer = new StringTokenizer(ctx.getUserPrincipal().getName(), ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
        final String header = tokenizer.nextToken();
        
        redis database = new redis();
        database.initiateServer();
        player player = new player(username, password);
		
        String exists;
        
        try{
        	if (database.auth(player)){
        		exists = "Player exists in database";
        		player.setCurrent(Integer.parseInt(database.getCurrent(player)));
        		player.setTotal(database.getTotal(player));
        		System.out.println(exists);
        		return true;
        	}else{
        		exists = "Player does not exist in database";
        		System.out.println(exists);
        		return false;
        	}
        }catch (NullPointerException e){
        	exists = "error";
        	System.out.println(exists);
        	return false;
        }

		/*
		String json = String.format("{ \"response\" : \"pong\","
				+ " \"authenticated\" : \"%s\","
				+ " \"header\" : \"%s\","
				+ " \"userName\" : \"%s\","
				+ " \"passWord\" : \"%s\","
				+ " \"location\" : \"%s\" }"
				, authString, header, username, password, exists);
				*/
		
	}
	
	@PUT
	@Produces("application/json")
	public boolean putPing(@Context SecurityContext ctx ) {
		
		// If the principal is null, then authentication failed.
		String authString = "yes";
		if( ctx.getUserPrincipal() == null ) {
			authString = "no";
			return false;
		}
		
		 //Split username and password tokens
        final StringTokenizer tokenizer = new StringTokenizer(ctx.getUserPrincipal().getName(), ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
        final String header = tokenizer.nextToken();
        
        redis database = new redis();
        database.initiateServer();
        player player = new player(username, password);
		
        String exists;
        
        try{
        	database.addUser(player);
        	exists = "Player loaded in database";
        	System.out.println(exists);

        	return true;

        }catch (NullPointerException e){
        	exists = "Player not loaded in database!";
        	System.out.println(exists);

        	return false;
        }
	}
	
	@DELETE
	@Produces("application/json")
	public boolean deletePing(@Context SecurityContext ctx ) {
		
		// If the principal is null, then authentication failed.
		String authString = "yes";
		if( ctx.getUserPrincipal() == null ) {
			authString = "no";
			return false;
		}
		
		 //Split username and password tokens
        final StringTokenizer tokenizer = new StringTokenizer(ctx.getUserPrincipal().getName(), ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
        final String header = tokenizer.nextToken();
        
        redis database = new redis();
        database.initiateServer();
        player player = new player(username, password);
		
        String exists;
        
        try{
        	database.removePlayer(player.getName());
        	exists = "Player removed from database";
        	System.out.println(exists);
        	return true;

        }catch (NullPointerException e){
        	exists = "Player not removed from database!";
        	System.out.println(exists);
        	return false;
        }

	}
	

}
