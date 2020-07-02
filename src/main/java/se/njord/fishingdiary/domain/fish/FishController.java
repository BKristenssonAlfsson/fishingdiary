package se.njord.fishingdiary.domain.fish;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fish")
@Stateless
public class FishController {

    @Inject
    private FishService fishService;

    @GET
    @Produces({"application/JSON"})
    public Response showFishes() {
        List<Fish> fishModel = fishService.getFishes();
        return Response.ok(fishModel).build();
    }

    @POST
    @Produces({"application/JSON"})
    public Response addFish(String fishObject) {
        try {
            FishModel fishModel = fishService.addFish(fishObject);
            return Response.accepted(fishModel).build();
        } catch ( Exception exception ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }
    }
}
