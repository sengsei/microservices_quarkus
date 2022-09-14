package de.prototype.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentalAndComment {

    private int rentalId;
    private String name;
    private String description;
    private List<CommentSummary> comments;

}
