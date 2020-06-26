package graphql.demo;

import graphql.demo.backend.PersonDB;
import graphql.demo.model.Person;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/rest")
@Tag(name = "Customer Service",description = "Getting customer data")
public class CustomerRestApi {

    @Inject
    PersonDB personDB;
    
    @GET
    @Path("/customer/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getCustomer(@PathParam("customerId") int customerId) {
        return personDB.getPerson(customerId);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @Inject
//    ScoreDB scoreDB;
//    
//    @GET
//    @Path("/score/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Score> getScore(@PathParam("id") String id) {
//        return scoreDB.getScores(id);
//    }
      
}