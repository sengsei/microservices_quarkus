package de.prototype.client;

import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;




@Singleton
@Path("/api/rentals")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RentalProxy {

    @GET
    @Path("/{id}")
    Uni<Rental> getRentalByRentalId(@PathParam("id") int rentalId);

    @POST
    Uni<Response> createRental(Rental rental, UriInfo uriInfo);

    @DELETE
    @Path("/{id}")
    Uni<Response> deleteRentalByRentalId(@PathParam("id") int rentalId);

}
