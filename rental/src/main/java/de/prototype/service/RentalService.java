package de.prototype.service;

import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

public interface RentalService {

    Uni<List<Rental>> getAllRentals();
    Uni<Rental> getRentalById(int rentalId);
    Uni<Response> createRental(Rental rental, UriInfo uriInfo);
    Uni<Response> updateRental(String id, Rental rental);
    Uni<Response> deleteRentalByRentalId(int rentalId);


}
