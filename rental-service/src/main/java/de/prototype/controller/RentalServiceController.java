package de.prototype.controller;



import de.prototype.model.Comment;
import de.prototype.model.Rental;
import de.prototype.model.RentalAndComment;
import de.prototype.service.RentalServiceIntegration;
import io.smallrye.mutiny.Uni;



import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;



@Path("/api/rentals-and-comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class RentalServiceController {


    @Inject
    RentalServiceIntegration integration;

    @GET
    @Path("/rentals/{id}")
    public Uni<Rental> getRentalByRentalId(@PathParam("id") int rentalId) {
        return integration.getRentalByRentalId(rentalId);
    }

    @GET
    @Path("/comments/{id}")
    public Uni<List<Comment>> getCommentsByRentalId(@PathParam("id") int rentalId) {
        return integration.getCommentsByRentalId(rentalId);
    }

    @GET
    @Path("/{rentalId}")
    public RentalAndComment getRental(@PathParam("rentalId") int rentalId) {
        return integration.getRentalAndCommentByRentalId(rentalId);
    }

    @POST
    public RentalAndComment createRentalAndComment(RentalAndComment rentalAndComment, UriInfo uriInfo){
        return integration.createRentalAndComment(rentalAndComment, uriInfo);
    }

    @DELETE
    @Path("/{rentalId}")
    public void deleteRentalAndCommentById(@PathParam("rentalId") int rentalId){
        integration.deleteRentalAndCommentById(rentalId);
    }

    @PUT
    @Path("/{rentalId}")
    public RentalAndComment updateRentalAndComment(RentalAndComment rentalAndComment,@PathParam("rentalId") int rentalId){
        return integration.updateRentalAndCommentById(rentalAndComment, rentalId);
    }





}



