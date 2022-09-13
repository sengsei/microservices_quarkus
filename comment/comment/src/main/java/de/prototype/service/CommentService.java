package de.prototype.service;

import de.prototype.model.Comment;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;
import java.util.List;

public interface CommentService {

    Uni<List<Comment>> getAllCommentsByRentalId(int rentalId);
    Uni<Response> createComment(Comment comment);
}
