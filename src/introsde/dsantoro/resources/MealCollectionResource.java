package introsde.dsantoro.resources;

import java.io.IOException;
import java.util.ArrayList;  // use it to store the list of Person to return 
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


//Will map the resource to the URL /person
@Path("/person")
public class MealCollectionResource {

    // Return the list of people to the user in the browser
    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> getPersonsList() {
        List<Person> people = new ArrayList<Person>();
        people.addAll(PersonDao.instance.getDataProvider().values());
        return people;
    }
}