package com.lutfibk.movieapi.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data //@Data = @Getter + @Setter + @ToString   from the lombok dependency
@AllArgsConstructor //constructer that take all meters
@NoArgsConstructor //constructer that take no meters
@Document(collection = "movies")
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;

}
