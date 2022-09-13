package de.prototype.service;

import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RentalServiceImpl implements RentalService {

    @Override
    public Uni<List<Rental>> getAllRentals() {
        return Rental.listAll();
    }

    @Override
    public Uni<Response> createRental(Rental rental) {
        return rental.<Rental>persist().map(r -> Response.ok(r).build());
    }

    @Override
    public Uni<Rental> updateRental(String id, Rental rental) {
        Uni<Rental> updatedRental = Rental.findById(new ObjectId(id));
        return updatedRental.onItem().transform(
                e -> {
                    e.setDescription(rental.getDescription());
                    e.setName(rental.getName());
                    return e;
                }
        ).call(e -> e.persistOrUpdate());
    }


}
