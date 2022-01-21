package com.homework2;

import io.swagger.models.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovieControllerIntegration extends BaseIntegration {

    @Test
    public void should_Create_Movie() {

        //given
        Movie movie = Movie.builder()
                .movieId(1L)
                .genre(Genre.Comedy)
                .releaseYear(2022)
                .directorName("directorName")
                .build();

        //when
        ResponseEntity<Movie> response = testRestTemplate.postForEntity("/movies", movie, Movie.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getMovieId()).isNotNull();

    }
    

    @Test
    public void should_Get_Movies_All(){

        ResponseEntity<List> response = testRestTemplate.getForEntity("/movies", List.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response).isNotNull();

    }

    @Test
    public void should_Get_Movies_ById(){

        //given
        Movie movie = Movie.builder().build();

        //when
        ResponseEntity<Movie> response = testRestTemplate.getForEntity("/movies/2", Movie.class);

        //then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("movie2");
        assertThat(response.getBody().getDirectorName()).isEqualTo("directorname2");

    }




}
