package de.prototype.controller;



import de.prototype.model.Rental;
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
    @Path("/{id}")
    public Uni<List<Rental>> getRentalByRentalId(@PathParam("id") int rentalId){
        return integration.getRentalByRentalId(rentalId);
    }
}
