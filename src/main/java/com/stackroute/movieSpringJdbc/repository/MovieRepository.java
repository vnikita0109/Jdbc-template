package com.stackroute.movieSpringJdbc.repository;

import com.stackroute.movieSpringJdbc.domain.Movie;
import com.stackroute.movieSpringJdbc.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class MovieRepository {
    private JdbcTemplate jdbcTemplate;

    public MovieRepository() {
    }

    @Autowired
    public void setJdbcTemplate(final DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll(){
        return jdbcTemplate.query("select * from movies",new MovieRowMapper());
    }

    public int add(Movie movie){
        return jdbcTemplate.update("insert into movies values(?,?,?,?)",movie.getMovieId(),movie.getMovieName(),movie.getReleaseYear(),movie.getRatings());
    }

    public Movie get(final String id){
        final String query="select * from movies where movieId=?";
        return jdbcTemplate.queryForObject(query,new Object[] {id},new MovieRowMapper());
    }

    public int update(Movie movie){
        return jdbcTemplate.update("update movies set movieName=? where movieId=?",movie.getMovieName(),movie.getMovieId());
    }

    public int delete(Movie movie){
        return jdbcTemplate.update("delete from movies where movieId=?",movie.getMovieId());
    }
}
