package de.prototype.service;

import de.prototype.model.Comment;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class CommentServiceImpl implements CommentService {

    @Override
    public Uni<List<Comment>> getAllCommentsByRentalId(int rentalId) {
        return Comment.list("rentalId", rentalId);
    }

    @Override
    public Uni<Response> createComment(Comment comment) {
        return comment.<Comment>persist().map(c -> Response.ok(c).build());
    }
}
