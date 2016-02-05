package introsde.dsantoro.foodessentials;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

public class FoodessentialsClient {
	
	private WebTarget service;
	private String apikey = null;
	private String apisid = null;
	
	public FoodessentialsClient() {
		// Get configuration
		apikey = System.getenv("FOOD_APIKEY");
		if (apikey != null) {
			// Setup service
			ClientConfig clientConfig = new ClientConfig();
	        Client client = ClientBuilder.newClient(clientConfig);
	        service = client.target(getBaseURI());
	        
	        // Get session 
	        String response = service.path("createsession")
	        .queryParam("uid","ert")
	        .queryParam("devid","ert")
	        .queryParam("appid","ert")
	        .queryParam("f","json")
	        .queryParam("v","2.00")
	        .queryParam("api_key",apikey)
	        .request().accept(MediaType.APPLICATION_JSON).get().readEntity(String.class);
	        apisid = (String) new org.json.JSONObject(response).get("session_id");	        
		}
		else {
			System.out.println("Foodessentials config: Missing variable FOOD_APIKEY");
		}
	}
	
	private static URI getBaseURI() {
        return UriBuilder.fromUri("http://api.foodessentials.com").build();
    }
	
	public JSONObject searchFoods(String key, int start, int num) {
		String response = service.path("searchprods")
		        .queryParam("q",key)
		        .queryParam("sid",apisid)
		        .queryParam("s",start)
		        .queryParam("f","json")
		        .queryParam("v","2.00")
		        .queryParam("api_key",apikey)
		        .queryParam("n",num)
		        .request().accept(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		return new JSONObject(response);
	}
	
	public JSONObject getFood(String upc) {
		String response = service.path("productscore")
		        .queryParam("u",upc)
		        .queryParam("sid",apisid)
		        .queryParam("f","json")
		        .queryParam("api_key",apikey)
		        .request().accept(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		return new JSONObject(response);
	}
}
