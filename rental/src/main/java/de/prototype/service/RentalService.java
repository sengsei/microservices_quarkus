package de.prototype.service;

import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;
import java.util.List;

public interface RentalService {

    Uni<List<Rental>> getAllRentals();
    Uni<Response> createRental(Rental rental);
    Uni<Rental> updateRental(String id, Rental rental);


}
