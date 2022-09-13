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
@MongoEntity(collection="rentals")
public class Rental extends ReactivePanacheMongoEntity {

    public int rentalId;
    public String name;
    public String description;

}
