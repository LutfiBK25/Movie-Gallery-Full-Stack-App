package com.lutfibk.movieapi.service;

import com.lutfibk.movieapi.model.Movie;
import com.lutfibk.movieapi.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    private final MovieRepository movieRepository;
    @Autowired
    MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public List<Movie> allMovies(){
        return movieRepository.findAll(); //from the mongodb dependency where find all returns all the data "Movie" passed in the repo
    }

    public Optional<Movie> getMovie(ObjectId id){ //we added the optional incase nothing found
        return movieRepository.findById(id);
    }

    public Optional<Movie>getMovieByImdb(String ImdbId){
        return movieRepository.findMovieByImdbId(ImdbId);
    }
}
