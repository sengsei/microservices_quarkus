package de.prototype.controller;

import de.prototype.model.Comment;
import de.prototype.service.CommentServiceImpl;
import io.smallrye.mutiny.Uni;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@NoArgsConstructor
@Path("/api/comments")
@ApplicationScoped
public class CommentController {

    @Inject
    CommentServiceImpl commentService;

    @GET
    @Path("/{id}")
    public Uni<List<Comment>> getAllCommentsByRentalId(@PathParam("id") int rentalId){
        return commentService.getAllCommentsByRentalId(rentalId);
    }

    @POST
    public Uni<Response> createComment(Comment comment){
        return commentService.createComment(comment);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Response>deleteCommentsByRentalId(@PathParam("id") int rentalId){
        return commentService.deleteAllCommentsByRentalId(rentalId);
    }

}
