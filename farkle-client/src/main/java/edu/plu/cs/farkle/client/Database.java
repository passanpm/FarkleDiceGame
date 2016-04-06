package edu.plu.cs.farkle.client;

import java.io.BufferedReader;

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
	static String username = "Gabjhkjkjdghhljbklkjbkde";
	static String password = "pecacjhjkhgfdhdfghheee";
	
	public static void main(String[] args){
		Database db = new Database(username, password);
		db.init("get");
		db.init("put");
		db.init("get");
		db.init("delete");
		db.init("get");
	}
	
	public Database(String username, String password) {
			Database.username = username;
			Database.password = password;
			
	}
	
	public void init(String action){
		Client client = null;
		try {
			client = ClientBuilder.newClient();
			// The target URL
			WebTarget target = client.target("http://localhost:8080/farkle/ping");

			ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget)client.target("http://localhost:8080/farkle/ping");
			resteasyWebTarget.register(new BasicAuthentication(username, password));
			
			switch (action){
				case "put":
					Response response = resteasyWebTarget.request().put(null);
				case "get":
					Response getUser = resteasyWebTarget.request().get();
				case "delete":
					Response remove = resteasyWebTarget.request().delete();
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
		}finally{
			client.close();
		}
	}
	
	

	
	

}