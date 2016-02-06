package introsde.dsantoro.endpoint;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.net.InetAddress;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;

public class AdpwsPublisher {
	public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
	{
		String PROTOCOL = "http://";
		String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
		if (HOSTNAME.equals("127.0.0.1"))
		{
			HOSTNAME = "localhost";
		}
		String PORT = "6904";
		String BASE_URL = "/ws/adpws";

		if (String.valueOf(System.getenv("PORT")) != "null"){
			PORT=String.valueOf(System.getenv("PORT"));
		}

		System.out.println("Starting adapter Service...");

		// Check setting variables for south-bound services        
		String apikey = System.getenv("FOOD_APIKEY");
		if (apikey != null) {
			URI BASE_URI = new URI(PROTOCOL + HOSTNAME + ":" + PORT + BASE_URL);	        
			JdkHttpServerFactory.createHttpServer(BASE_URI, new AdpwsConfig());
			System.out.println("--> Published. Check out "+BASE_URI);
		}
		else {
			// Cannot connect to dependent services
			System.out.println("--> ERROR: Not published. Check out dependent services:");
			System.out.println("----> FOO_APIKEY: " + apikey);
		}        
	}

}