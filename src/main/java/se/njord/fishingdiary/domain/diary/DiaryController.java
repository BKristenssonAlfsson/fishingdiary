package se.njord.fishingdiary.domain.diary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/diary")
@Stateless
public class DiaryController {

    @Inject
    private DiaryService diaryService;

    private DiaryModel diaryModel = new DiaryModel();

    @POST
    @Produces({"application/JSON"})
    public Response addDiary(String username) {
        try {
            diaryModel = diaryService.createDiary(username);
            return Response.ok(diaryModel).build();
        } catch ( Exception e ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces({"application/JSON"})
    public Response getAllDiaries() {
        try {
            List<DiaryModel> diaryModelList = diaryService.getAllDiaries();
            return Response.ok().entity(diaryModelList).build();
        } catch ( Exception e ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{username}")
    @Produces({"application/JSON"})
    public Response getDiaryByNumber(@PathParam("username") String username) {
        try {
            DiaryModel diaryModel = diaryService.getOneDiary(username);
            return Response.ok().entity(diaryModel).build();
        } catch ( Exception e ) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
