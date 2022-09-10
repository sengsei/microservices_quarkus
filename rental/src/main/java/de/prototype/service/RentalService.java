package de.prototype.service;
import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import java.util.List;

public interface RentalService {
    Uni<List<Rental>> listAll();
    Uni<Rental> save(Rental rental);
}
