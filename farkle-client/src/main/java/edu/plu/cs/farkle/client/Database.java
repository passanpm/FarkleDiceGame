package edu.plu.cs.farkle.client;

import java.io.BufferedReader;
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

public class Database {
	Player user = new Player();
	static String username = "Gabjhkjkjdghhljbklkjbkde";
	static String password = "pecacjhjkhgfdhdfghheee";

	public static void main(String[] args){
		Database d = new Database(username, password);
		d.put();
		//System.out.println(d.get().getTotal());
		d.get();
		d.delete();
	}
	
	public Database(String username, String password) {
			Database.username = username;
			Database.password = password;
			System.out.println("DEBUG: " + username);
	}
	
	public void put(){
		init("put");
	}
	public void get(){
		init("get");
	}
	public void delete(){
		init("delete");
	}
	
	public void init(String action){
		Client client = null;
		try {
			client = ClientBuilder.newClient();
			// The target URL
			WebTarget target = client.target("http://localhost:8080/farkle/ping");

			ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget)client.target("http://localhost:8080/farkle/ping");
			resteasyWebTarget.register(new BasicAuthentication(username, password));
			Player p = new Player();
			Entity<Player> u = Entity.json(p);
			
			switch (action){
				case "put":
					Response response = resteasyWebTarget.request().put(u);
				case "get":
					Response getUser = resteasyWebTarget.request().get();
					
					System.out.println("-----------------------------------> " + getUser);
				case "delete":
					Response remove = resteasyWebTarget.request().delete();
				case "post":
					Response update = resteasyWebTarget.request().post(u);
			}
			
		} catch (Exception e) {
		}finally{
			client.close();
		}
	}
	
	

	
	

}
