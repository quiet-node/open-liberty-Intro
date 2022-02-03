package liberty.demo.rest.Resources;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import liberty.demo.rest.dao.TeamNameDAO;

@RequestScoped
@Path("/teamnames") 
public class TeamNameResource {

    @Inject
    private TeamNameDAO teamNameDAO; // Injected and used to access and persist data

    // @route:   Post api/teamnames
    // @desc:    Creates new teamName
    // @access   public
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional 
    public Response addNewTeamName(@RequestBody JsonObject teamName) {
        
    }


    @GET
    public String getTeams() {
        return "Teams Br99Mi00";
    }
}
