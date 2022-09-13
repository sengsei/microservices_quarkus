package de.prototype.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection="comments")
public class Comment extends ReactivePanacheMongoEntity {

    private int rentalId;
    private int commentId;
    private String username;
    private String content;
}
