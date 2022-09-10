package de.prototype.controller;
import de.prototype.model.Rental;
import de.prototype.service.RentalServiceImpl;
import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Path("/api/rentals")
public class RentalController {

    @Inject
    RentalServiceImpl rentalService;

    @GET
    @Produces
    public Uni<List<Rental>> getAllRentals() {
        return rentalService.listAll();
    }

    @POST
    @Produces
    @Consumes
    public Uni<Rental> createRental(Rental rental){
        return rentalService.save(rental);
    }


}
