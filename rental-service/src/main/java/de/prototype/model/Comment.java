package de.prototype.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment  {

    private int rentalId;
    private int commentId;
    private String username;
    private String content;
}
