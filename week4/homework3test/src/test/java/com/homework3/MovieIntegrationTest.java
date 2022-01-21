package com.homework3;

import com.homework3.Model.Movie;
import com.homework3.Repository.JpaRepository;
import com.homework3.Service.MovieService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovieIntegrationTest extends BaseIntegrationTest {

    @Autowired
    JpaRepository jpaRepository;

    @Autowired
    MovieService movieService;

    @Test
    public void should_create_movie(){
        //given
        Movie movie = new Movie();
        movie.setGenre(MovieGenre.ACTION);
        movie.setDirector("director");
        movie.setReleaseYear(2022);
        movie.setName("movieName");

        //when
        ResponseEntity<Movie> response = testRestTemplate.postForEntity("/movies", movie, Movie.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();

    }

    @Test
    public void delete_Movie_By_Id(){

        //given
        Movie movie = new Movie();
        movie.setName("movieName");
        movie.setGenre(MovieGenre.COMEDY);
        movie.setDirector("directorName");
        movie.setReleaseYear(2022);
        movie.setId(10L);

        //when
        jpaRepository.save(movie);
        jpaRepository.delete(movie);

        //then
        assertThat(jpaRepository.existsById(10L)).isFalse();
    }


    @Test
    @Sql(scripts = "/movieGetById.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/movieDeleteById.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void get_MovieAll(){

        //given
        ResponseEntity<List<Movie>> response;

        //when
        response = testRestTemplate.exchange("/movies", HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {});

        //then
        assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody()).hasSizeGreaterThan(0);

    }


}
