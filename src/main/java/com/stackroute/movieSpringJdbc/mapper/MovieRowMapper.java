package com.stackroute.movieSpringJdbc.mapper;

import com.stackroute.movieSpringJdbc.domain.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        final Movie movie=new Movie();
        movie.setMovieId(resultSet.getInt("MOVIE_ID"));
        movie.setMovieName(resultSet.getString("MOVIE_NAME"));
        movie.setReleaseYear(resultSet.getInt("RELEASE_YEAR"));
        movie.setRatings(resultSet.getByte("RATINGS"));
        return movie;
    }
}
