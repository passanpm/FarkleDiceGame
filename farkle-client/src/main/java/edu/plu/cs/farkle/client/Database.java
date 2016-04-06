package edu.plu.cs.farkle.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class Database {
	
	public static void main(String[] args){
		String username = "Gabe";
		String password = "password";
		Database db = new Database(username, password);
	}
	public Database(String username, String password) {
		
				// Create a new HTTP client object
				Client client = ClientBuilder.newClient();
				

				try {
				
					// The target URL
					WebTarget target = client.target("http://localhost:8080/farkle/ping");

					ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget)client.target("http://mywebservice/rest/api");
					resteasyWebTarget.register(new BasicAuthentication(username, password));
					Response theUser = target.request().get();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// Make sure that we always close the client.
					client.close();
				}
	}
	
	

}
