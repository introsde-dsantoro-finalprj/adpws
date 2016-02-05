package introsde.dsantoro.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import introsde.dsantoro.dao.AdpDaoImpl;
import introsde.dsantoro.model.Meal;


@Path("/meals")
public class MealCollectionResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	
	@GET
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Meal> getFilteredMeals(@QueryParam("key") String key, @QueryParam("start") int start, @QueryParam("n") int n) {
		return (List<Meal>) new AdpDaoImpl().searchMeals(key, start, n);
	}
}