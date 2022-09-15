package de.prototype.controller;



import de.prototype.model.Comment;
import de.prototype.model.CommentSummary;
import de.prototype.model.Rental;
import de.prototype.model.RentalAndComment;
import de.prototype.service.RentalServiceIntegration;
import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/rentals-and-comments")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class RentalServiceController {



    @Inject
    RentalServiceIntegration integration;

    @GET
    @Path("/rentals/{id}")
    public Uni<Rental> getRentalByRentalId(@PathParam("id") int rentalId){
        return integration.getRentalByRentalId(rentalId);
    }

    @GET
    @Path("/comments/{id}")
    public Uni<List<Comment>> getCommentsByRentalId(@PathParam("id") int rentalId){
        return integration.getCommentsByRentalId(rentalId);
    }

    /*
    @GET
    @Path("/{rentalId}")
    public Uni<RentalAndComment>getRental(@PathParam("rentalId") int rentalId){
        Uni<List<Rental>> rental = integration.getRentalByRentalId(rentalId);
        Uni<List<Comment>> comments = integration.getCommentsByRentalId(rentalId);
        return createRentalAndComment(rental, comments);
    }





    private Uni<RentalAndComment> createRentalAndComment(Uni<List<Rental>> rentalList, Uni<List<Comment>> comments) {



        Uni<RentalAndComment> ret = rental.onItem().transform(
                e -> {
                    e.get(0).setRentalId(e.get(0).getRentalId());
                    e.get(0).setName(e.get(0).getName());
                    e.get(0).setDescription(e.get(0).getDescription());
                    return e;
                }
        ).call()


      /*  int rentalId =
        String name = rental.getName();
        String description = rental.getDescription();

        List<CommentSummary> commentSummaries = comments.stream()
                .map(c -> new CommentSummary(c.getCommentId(), c.getUsername(), c.getContent())).collect(Collectors.toList());

        return new Uni<RentalAndComment>(rentalId, name, description, commentSummaries);

       */
    }



