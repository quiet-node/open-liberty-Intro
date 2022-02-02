package liberty.demo.rest.Resources;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/teams") 
@ApplicationScoped
public class RestResources {
    @GET
    public String getTeams() {
        return "Teams Br99Mi00";
    }
}
