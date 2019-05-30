package com.stackroute.movieSpringJdbc.configuration;

import com.stackroute.movieSpringJdbc.controller.MovieSpringJdbcController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.stackroute.*")
public class MovieSpringJdbcConfig {

    @Bean("dataSource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@123");

        return dataSource;
    }

    @Bean("movieSpringJdbcController")
    public MovieSpringJdbcController methodforController(){
        return new MovieSpringJdbcController();
    }
}
