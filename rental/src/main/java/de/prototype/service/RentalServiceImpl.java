package de.prototype.service;

import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;


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
    public Uni<Rental> getRentalById(int rentalId) {
        return Rental.find("rentalId", rentalId).firstResult();
    }

    @Override
    public Uni<Response> createRental(Rental rental, @Context UriInfo uriInfo) {
        return rental.<Rental>persist().map(r -> {
            UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(r.getRentalId()));
            return Response.created(builder.build()).build();
                });

    }

    @Override
    public Uni<Response> updateRental(int rentalId, Rental rental) {

        Uni<Rental> updatedRental = Rental.find("rentalId", rentalId).firstResult();

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
    public Uni<Response> deleteRentalByRentalId(int rentalId) {
        return Rental.delete("rentalId", rentalId).replaceWith(Response.noContent().build());
    }


}
