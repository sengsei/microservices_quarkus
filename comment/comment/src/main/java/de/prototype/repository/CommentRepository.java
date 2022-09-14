package de.prototype.repository;

import de.prototype.model.Comment;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


public class CommentRepository implements ReactivePanacheMongoRepository<Comment> {

}
