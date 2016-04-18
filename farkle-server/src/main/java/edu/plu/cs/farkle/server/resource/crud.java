package edu.plu.cs.farkle.server.resource;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import edu.plu.cs.farkle.server.auth.player;
import edu.plu.cs.farkle.server.auth.redis;

/**
 * This is a simple example, not intended for use in the final product.
 * 
 * Responds with a JSON "pong" when requested via GET
 */
@Path("/crud")
public class crud {
	
	
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
	public String get(@Context SecurityContext ctx ) {
		
		// If the principal is null, then authentication failed.
		String authString = "yes";
		if( ctx.getUserPrincipal() == null ) {
			authString = "no";
			return null;
		}
		
		System.out.println(authString);
		 //Split username and password tokens
        final StringTokenizer tokenizer = new StringTokenizer(ctx.getUserPrincipal().getName(), ":");
        System.out.println(tokenizer);
        final String username = tokenizer.nextToken();
        System.out.println("username");
        final String password = tokenizer.nextToken();
        System.out.println("password");
        
        redis database = new redis();
        database.initiateServer();
        player player = new player(username, password);
		
        String exists;
        
        try{
        	if (database.auth(player)){
        		exists = "Player exists in database";
        		player.setCurrent(Integer.parseInt(database.getCurrent(player)));
        		player.setTotal(database.getTotal(player));
        	}else{
        		exists = "Player does not exist in database";

        		return null;
        	}
        }catch (NullPointerException e){
        	exists = "error";
        	System.out.println(exists);
        	return null;
        }

		
		String json = String.format("{ \"response\" : \"pong\","
				+ " \"username\" : \"%s\","
				+ " \"password\" : \"%s\","
				+ " \"current\" : \"%s\","
				+ " \"total\" : \"%s\" }"
				, player.getName(), player.getPass(), player.getCurrent(), player.getTotal());
		return json;
	
		
	}
	
	@PUT
	@Produces("application/json")
	public boolean put(@Context SecurityContext ctx ) {
		
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


        	return true;

        }catch (NullPointerException e){
        	exists = "Player not loaded in database!";


        	return false;
        }
	}
	
	@DELETE
	@Produces("application/json")
	public boolean delete(@Context SecurityContext ctx ) {
		
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

        	return true;

        }catch (NullPointerException e){
        	exists = "Player not removed from database!";

        	return false;
        }

	}
	
	@POST
	@Produces("application/json")
	public String post(@Context SecurityContext ctx ) {
		
		// If the principal is null, then authentication failed.
		String authString = "yes";
		if( ctx.getUserPrincipal() == null ) {
			authString = "no";
			return null;
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

        	}else{
        		exists = "Player does not exist in database";

        		return null;
        	}
        }catch (NullPointerException e){
        	exists = "error";
        	System.out.println(exists);
        	return null;
        }

		
		String json = String.format("{ \"response\" : \"pong\","
				+ " \"username\" : \"%s\","
				+ " \"password\" : \"%s\","
				+ " \"current\" : \"%s\","
				+ " \"total\" : \"%s\" }"
				, player.getName(), player.getPass(), player.getCurrent(), player.getTotal());
		return json;
		
	}
	

}