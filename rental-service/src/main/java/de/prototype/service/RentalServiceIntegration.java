package de.prototype.service;


import de.prototype.client.CommentProxy;
import de.prototype.client.RentalProxy;
import de.prototype.model.Comment;
import de.prototype.model.Rental;
import de.prototype.model.RentalAndComment;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;
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

    public RentalAndComment getRentalAndCommentByRentalId(int rentalId){
        Uni<Rental> rental = rentalProxy.getRentalByRentalId(rentalId);
        Uni<List<Comment>> comments = commentProxy.getCommentsByRentalId(rentalId);
        RentalAndComment rentalAndComment = new RentalAndComment();
        rentalAndComment.setRentalId(rentalId);
        rentalAndComment.setName(rental.onItem().transform(Rental::getName).await().indefinitely());
        rentalAndComment.setDescription(rental.onItem().transform(Rental::getDescription).await().indefinitely());
        rentalAndComment.setComments(comments.onItem().transform(e -> e).await().indefinitely());
        return rentalAndComment;
    }

    public RentalAndComment createRentalAndComment(RentalAndComment rentalAndComment, UriInfo uriInfo){
        Rental rental = new Rental();
        rental.setRentalId(rentalAndComment.getRentalId());
        rental.setName(rentalAndComment.getName());
        rental.setDescription(rentalAndComment.getDescription());
        rentalProxy.createRental(rental,  uriInfo).await().indefinitely();

        List<Comment> comments = rentalAndComment.getComments();
        for (Comment comment : comments){
            commentProxy.createComment(comment).await().indefinitely();
        }
        return rentalAndComment;
    }

}
