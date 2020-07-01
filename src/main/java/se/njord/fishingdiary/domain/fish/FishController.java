package se.njord.fishingdiary.domain.fish;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/fish")
@Stateless
public class FishController {

    @Inject
    private FishService fishService;

    @GET
    @Produces({"application/JSON"})
    public Response showFishes() {
        System.out.println("In Controller");
        String test = fishService.getFishes();
        return Response.ok(test).build();
    }
}
