package edu.plu.cs.farkle.server.resource;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
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

import org.codehaus.jackson.JsonNode;

import edu.plu.cs.farkle.server.auth.player;
import edu.plu.cs.farkle.server.auth.redis;

/**
 * This is a simple example, not intended for use in the final product.
 * 
 * Responds with a JSON "pong" when requested via GET
 */
@Path("/crud")
public class crud {
	
	redis database = new redis();
    player player = new player();
	
	
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
        
		
        
        try{
        	if (database.auth(player)){
        		player.setName(database.getName(player.getName()));
        		player.setPass(database.getPass(player.getName()));
        		player.setWins(Integer.parseInt(database.getWins(player)));
        		player.setTotal(Integer.parseInt(database.getTotal(player)));
        		database = new redis();
        	}else{
        		System.out.println("Player does not exist");
        	}
        }catch (NullPointerException e){
        	System.out.println("error");
        }

		
		String json = String.format("{ "
				+ " \"name\" : \"%s\","
				+ " \"pass\" : \"%s\","
				+ " \"wins\" : \"%s\","
				+ " \"total\" : \"%s\" }"
				, player.getName(), player.getPass(), player.getWins(), player.getTotal());
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

        player.setName(username);
        player.setPass(password);

        
        try{
        	database.addUser(player);
        	database = new redis();


        	return true;

        }catch (NullPointerException e){

        	database = new redis();
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
        
        try{
        	database.removePlayer(player.getName());
        	player = new player();
        	database = new redis();

        	return true;

        }catch (NullPointerException e){
        	database = new redis();

        	return false;
        }

	}
	
	@POST
	@Consumes("application/json")
	public void post(JsonNode node, @Context SecurityContext ctx) {
		
		
		
		// If the principal is null, then authentication failed.
		String authString = "yes";
		if( ctx.getUserPrincipal() == null ) {
			authString = "no";
		}
        
        
        try{
        	if (database.auth(player)){
        		database.setName(player.getName(), node.get("name").getTextValue());
        		player.setName(node.get("name").getTextValue());
        		
        		database.setPass(player.getName(), node.get("pass").getTextValue());
        		database.setWins(player.getName(), node.get("wins").getTextValue());
        		database.setTotal(player.getName(), node.get("total").getTextValue());
        	}else{
        		System.out.println("player not authenticated");
        	}
        }catch (NullPointerException e){

        }
        
        
        database = new redis();
		
		
	}
	

}
