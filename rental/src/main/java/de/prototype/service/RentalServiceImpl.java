package de.prototype.service;

import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@ApplicationScoped
public class RentalServiceImpl implements RentalService {

    @Override
    public Uni<List<Rental>> getAllRentals() {
        return Rental.listAll();
    }

    @Override
    public Uni<List<Rental>> getRentalById(int rentalId) {
        return Rental.list("rentalId", rentalId);
    }

    @Override
    public Uni<Response> createRental(Rental rental, @Context UriInfo uriInfo) {
        return rental.<Rental>persist().map(r -> {
            UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(r.getRentalId()));
            return Response.created(builder.build()).build();
                });

    }

    @Override
    public Uni<Response> updateRental(String id, Rental rental) {
        Uni<Rental> updatedRental = Rental.findById(new ObjectId(id));
        return updatedRental.onItem().transform(
                e -> {
                    e.setRentalId(rental.getRentalId());
                    e.setDescription(rental.getDescription());
                    e.setName(rental.getName());
                    return e;
                }
        ).call(e -> e.persistOrUpdate()).replaceWith(Response.ok().build());
    }

    @Override
    public Uni<Response> deleteRentalById(String id) {
        return Rental.deleteById(new ObjectId(id)).replaceWith(Response.noContent().build());
    }


}
