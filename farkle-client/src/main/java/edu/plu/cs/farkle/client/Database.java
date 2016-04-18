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

public class Database {



	Player user = new Player();
	static String username = "Gabe";
	static String password = "pecache";


	public static void main(String[] args){
		Database d = new Database(username, password);
		d.get();
		d.put();
		d.get();
		d.delete();
		d.get();
		d.post();
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
	public void post(){
		init("post");
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
					Invocation.Builder builder = resteasyWebTarget.request();
					String r = builder.get(String.class);
					ObjectMapper mapper = new ObjectMapper();
					JsonNode node = mapper.readTree(r);
					
					
					System.out.println(node.toString());
					System.out.println("Name: " + node.get("username"));
					client.close();
					
				case "delete":
					Response remove = resteasyWebTarget.request().delete();
				case "post":
					Invocation.Builder builder1 = resteasyWebTarget.request();
					String r1 = builder1.get(String.class);
					ObjectMapper mapper1 = new ObjectMapper();
					JsonNode node1 = mapper1.readTree(r1);
					
					
					System.out.println("BEFORE;");
					System.out.println(node1.toString());
					((ObjectNode)node1).put("username", "Gabriel");
					System.out.println("AFTER;");
					System.out.println(node1.toString());
					
					
					
					((ObjectNode)node1).put("username", "Gabe");
					client.close();
					
			}
			
		} catch (Exception e) {
		}finally{
			client.close();
		}
	}
	
	

	
	

}
