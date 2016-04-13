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
	player user = new player();
	static String username = "Gabe";
	static String password = "pecache";

	public static void main(String[] args){
		Database d = new Database(username, password);
		d.get();
		d.put();
		d.get();
		d.delete();
		d.get();
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
			player p = new player();
			Entity<player> u = Entity.json(p);
			
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
					
				case "delete":
					Response remove = resteasyWebTarget.request().delete();
				case "post":
					Invocation.Builder builder2 = resteasyWebTarget.request();
					String newName = "0";
					Entity<String> username = Entity.json(newName);
					String r2 = builder2.post(username, String.class);
			}
			
		} catch (Exception e) {
		}finally{
			client.close();
		}
	}
	
	

	
	

}
