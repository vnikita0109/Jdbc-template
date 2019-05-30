package com.stackroute.movieSpringJdbc.controller;

import com.stackroute.movieSpringJdbc.domain.Movie;
import com.stackroute.movieSpringJdbc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieSpringJdbcController {
    Movie movie=null;
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<String> executeShow(){
        movie=movieRepository.get("1005");
        return new ResponseEntity<String>("Movie : "+movie.getMovieId()+","+movie.getMovieName(), HttpStatus.OK);
    }

    public ResponseEntity<String> insert(){
        movie=new Movie(1005,"Letter to Tomoro",2001,8);
        movieRepository.add(movie);
        return new ResponseEntity<String>("Add movie : "+movie.getMovieId()+","+movie.getMovieName()+","+movie.getReleaseYear()+","+movie.getRatings(),HttpStatus.OK);

    }

    public ResponseEntity<String> read(){
        movie=movieRepository.get("1005");
        return new ResponseEntity<String>("Get movie : "+movie.getMovieId()+","+movie.getMovieName()+","+movie.getReleaseYear()+","+movie.getRatings(),HttpStatus.OK);
    }

    public ResponseEntity<String> update() {
        movie = new Movie(1002,"Grave of fireflies",1988,7);
        movieRepository.update(movie);
        return new ResponseEntity<String>("Update movie : "+movie.getMovieId()+","+movie.getMovieName()+","+movie.getReleaseYear()+","+movie.getRatings(),HttpStatus.OK);
    }

    public ResponseEntity<String> delete() {
        movie = new Movie(1003,"Wolf Children",2012,8);
        movieRepository.delete(movie);
        return new ResponseEntity("Delete movie : "+movie.getMovieId()+","+movie.getMovieName()+","+movie.getReleaseYear()+","+movie.getRatings(),HttpStatus.OK);
    }
    public ResponseEntity<?> getAll() {
        List<Movie> movieList =movieRepository.getAll();
        return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
    }
}
