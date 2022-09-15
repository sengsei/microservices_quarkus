package de.prototype.controller;



import de.prototype.model.Comment;
import de.prototype.model.Rental;
import de.prototype.model.RentalAndComment;
import de.prototype.service.RentalServiceIntegration;
import io.smallrye.mutiny.Uni;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api/rentals-and-comments")
@Produces(MediaType.APPLICATION_JSON)
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



}



