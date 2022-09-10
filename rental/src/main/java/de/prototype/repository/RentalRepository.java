package de.prototype.repository;
import de.prototype.model.Rental;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RentalRepository implements ReactivePanacheMongoRepository<Rental> {

}
