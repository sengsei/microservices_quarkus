package de.prototype.client;

import de.prototype.model.Comment;
import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Singleton
@Path("/api/comments")
@RegisterRestClient
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CommentProxy {

    @GET
    @Path("/{id}")
    Uni<List<Comment>> getCommentsByRentalId(@PathParam("id") int rentalId);

    @POST
    Uni<Response> createComment(Comment comment);
}
