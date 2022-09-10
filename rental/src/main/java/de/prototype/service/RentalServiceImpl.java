package de.prototype.service;
import de.prototype.model.Rental;
import de.prototype.repository.RentalRepository;
import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RentalServiceImpl implements RentalService {

    @Inject
    RentalRepository rentalRepository;

    @Override
    public Uni<List<Rental>> listAll() {
        return rentalRepository.listAll();
    }

    @Override
    public Uni<Rental> save(Rental rental) {
        return rentalRepository.persist(rental);
    }


}
