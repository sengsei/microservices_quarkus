package de.prototype.client;

import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/api/rentals")
@RegisterRestClient
public interface RentalProxy {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<Rental>> getRentalByRentalId(@PathParam("id") int rentalId);
}
