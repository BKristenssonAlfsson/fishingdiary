package se.njord.fishingdiary.domain.fishspecies;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("/species")
public class FishSpeciesController {

    @Inject
    FishSpeciesService fishSpeciesService;

    @GET
    @Produces("application/JSON")
    public Response getAllSpecies() {
        try {
            return Response.ok().entity(fishSpeciesService.getAllSpecies()).build();
        } catch ( Exception e ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Produces("application/JSON")
    public Response addSpecies(String fish) {
        try {
            return Response.ok().entity(fishSpeciesService.addSpecies(fish)).build();
        } catch ( Exception e ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
