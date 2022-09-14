package de.prototype.service;


import de.prototype.client.RentalProxy;
import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RentalServiceIntegration {

    @RestClient
    RentalProxy rentalProxy;

    public Uni<List<Rental>> getRentalByRentalId(int rentalId) {
        return rentalProxy.getRentalByRentalId(rentalId);
    }

}
