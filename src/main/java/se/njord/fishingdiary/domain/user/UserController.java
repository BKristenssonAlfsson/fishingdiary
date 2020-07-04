package se.njord.fishingdiary.domain.user;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/user")
@Stateless
public class UserController {

    private UserModel userModel = new UserModel();

    @Inject
    UserService userService;

    @POST
    @Produces({"application/JSON"})
    public Response addUser(String userModel) {
        try {
            this.userModel = userService.addUser(userModel);
            return Response.ok(this.userModel).build();
        } catch ( Exception e ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces({"application/JSON"})
    public Response getAllUsers() {
        try {
            return Response.ok(userService.getAllUsers()).build();
        } catch ( Exception e ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
