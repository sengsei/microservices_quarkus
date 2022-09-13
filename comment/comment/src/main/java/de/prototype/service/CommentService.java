package de.prototype.service;

import de.prototype.model.Comment;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface CommentService {

    Uni<List<Comment>> getAllCommentsByRentalId(int rentalId);
}
