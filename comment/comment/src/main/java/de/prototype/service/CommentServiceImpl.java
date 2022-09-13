package de.prototype.service;

import de.prototype.model.Comment;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CommentServiceImpl implements CommentService {

    @Override
    public Uni<List<Comment>> getAllCommentsByRentalId(int rentalId) {
        return Comment.list("rentalId", rentalId);
    }
}
