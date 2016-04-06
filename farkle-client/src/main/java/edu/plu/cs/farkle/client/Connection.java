package edu.plu.cs.farkle.client;

public interface Connection {
	@GET
	@PATH("http://localhost:8080/farkle/ping")
	@PRODUCES("text/plain")
	String getUser();
}
