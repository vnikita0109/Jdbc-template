package com.stackroute.movieSpringJdbc;

import com.stackroute.movieSpringJdbc.configuration.MovieSpringJdbcConfig;
import com.stackroute.movieSpringJdbc.controller.MovieSpringJdbcController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )throws Exception
    {
        System.out.println( "Hello Database" );

        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext();
        configApplicationContext.register(MovieSpringJdbcConfig.class);
        configApplicationContext.refresh();

        MovieSpringJdbcController movieSpringJdbcController= (MovieSpringJdbcController) configApplicationContext.getBean("movieSpringJdbcController");
        System.out.println(movieSpringJdbcController.getAll());

        System.out.println(movieSpringJdbcController.insert());
        //System.out.println(movieSpringJdbcController.getAll());

        System.out.println(movieSpringJdbcController.delete());
        //System.out.println(movieSpringJdbcController.getAll());

        System.out.println(movieSpringJdbcController.read());

        System.out.println(movieSpringJdbcController.update());
        System.out.println(movieSpringJdbcController.getAll());

        System.out.println(movieSpringJdbcController.executeShow());
    }
}
