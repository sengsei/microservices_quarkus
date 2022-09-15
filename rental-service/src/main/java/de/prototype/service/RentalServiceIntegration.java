package de.prototype.service;


import de.prototype.client.CommentProxy;
import de.prototype.client.RentalProxy;
import de.prototype.model.Comment;
import de.prototype.model.Rental;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RentalServiceIntegration {

    @RestClient
    RentalProxy rentalProxy;

    @RestClient
    CommentProxy commentProxy;

    public Uni<Rental> getRentalByRentalId(int rentalId) {
        return rentalProxy.getRentalByRentalId(rentalId);
    }

    public Uni<List<Comment>> getCommentsByRentalId(int rentalId){
        return commentProxy.getCommentsByRentalId(rentalId);
    }



}
