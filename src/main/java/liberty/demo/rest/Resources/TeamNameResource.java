package liberty.demo.rest.Resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import liberty.demo.rest.dao.TeamNameDAO;
import liberty.demo.rest.models.TeamName;

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
        String nameA = teamName.getString("nameA"); // Br
        String nameB = teamName.getString("nameB"); // Mi
        String yearA = teamName.getString("yearA"); // 99
        String yearB = teamName.getString("yearB"); // 00

        TeamName newTeamName = new TeamName(0, nameA, nameB, yearA, yearB); // data instance
        
        // If teamname exists, return bad request
        if(!teamNameDAO.findTeamName(nameA, nameB, yearA, yearB).isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Team Name already exists").build();
        }

        // if team name is available, create new TeamName to data source
        teamNameDAO.createTeamName(newTeamName); 

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/urle")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Transactional
    public Response addNewTeamName(@FormParam("nameA") String nameA,
        @FormParam("nameB") String nameB, @FormParam("yearA") String yearA, @FormParam("yearB") String yearB ) {
        TeamName newTeamName = new TeamName(0, nameA, nameB, yearA, yearB);
        if(!teamNameDAO.findTeamName(nameA, nameB, yearA, yearB).isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("TeamName already exists").build();
        }
        teamNameDAO.createTeamName(newTeamName);
        return Response.status(Response.Status.NO_CONTENT).build(); 
    }

    // @route:   GET api/teamnames
    // @desc:    Get all team names
    // @access   public
    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // @Transactional
    // public JsonArray getTeamNames() {
    //     // get JSON result
    //     JsonObjectBuilder res = Json.createObjectBuilder(); 
    //     JsonArrayBuilder resArray = Json.createArrayBuilder();

    //     // loop through the list of teamName, then add them to the res JsonObject 
    //     for (TeamName teamName : teamNameDAO.getAllTeamNames()) {
    //         res
    //         .add("nameA", teamName.getNameA())
    //         .add("nameB", teamName.getNameB()) 
    //         .add("yearA", teamName.getYearA()) 
    //         .add("yearB", teamName.getYearB())
    //         .add("id", teamName.getId());

    //         resArray.add((res.build())); // push to an JSON array
    //     }

    //     return resArray.build();

    // }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getTeams(@RequestBody JsonObject object) {

        return object;
    }
    
}
