package de.prototype.controller;
import de.prototype.model.Rental;

import de.prototype.service.RentalServiceImpl;
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
@Path("/api/rentals")
@ApplicationScoped
public class RentalController {

    @Inject
    RentalServiceImpl rentalService;


    @GET
    public Uni<List<Rental>> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GET
    @Path("/{id}")
    public Uni<Rental> getRentalById(@PathParam("id") String id){
        return rentalService.getRentalById(id);
    }

    @POST
    public Uni<Response> createRental(Rental rental) {
        return rentalService.createRental(rental);
    }

    @PUT
    @Path("/{id}")
    public Uni<Rental> updateRental(@PathParam("id") String id, Rental rental) {
        return rentalService.updateRental(id, rental);
    }




}
