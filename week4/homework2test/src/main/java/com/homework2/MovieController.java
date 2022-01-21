package com.homework2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;


@RestController
public class MovieController {

		@GetMapping("/movies")
		@ResponseStatus(HttpStatus.OK)
		public Set<Movie> GetMovies()
		{
			//Default get isteği yapıldığında çalışacak alandır.url localhost:8080/movies şeklinde olmalı ve get isteği olmalıdır. 
			ArrayList<String> casts1 = new ArrayList<String>();
			casts1.add("name1");
			casts1.add("name2");
			casts1.add("name3");
			casts1.add("name4");
			ArrayList<String> casts2 = new ArrayList<String>();
			casts2.add("name1");
			casts2.add("name2");
			
			return Set.of(
					Movie.builder()
					.movieId(1)
					.name("movieName1")
					.genre(Genre.Comedy)
					.releaseYear(2020)
					.directorName("name1")
					.cast(casts1)
					.build(),
					Movie.builder()
					.movieId(2)
					.name("movieName2")
					.genre(Genre.Thriller)
					.releaseYear(2020)
					.directorName("name2")
					.cast(casts2)
					.build()
					);
		}
	
	
		@PostMapping("/movies")
		@ResponseStatus(HttpStatus.CREATED)
		public Movie CreateMovie(@RequestBody Movie movie)
		{
			//post isteği yapıldığında çalışacak alandır.url localhost:8080/movies post isteği ile bodye json parametreleri, movieId,name,genre,releaseYear,directorName ve cast değerleri yazılmalıdır.
			return Movie.builder()
					.movieId(movie.getMovieId())
					.name(movie.getName())
					.genre(movie.getGenre())
					.releaseYear(movie.getReleaseYear())
					.directorName(movie.getDirectorName())
					.cast(movie.getCast())
					.build();
		}
		
		@GetMapping("/movies/{movieId}")
		@ResponseStatus(HttpStatus.OK)
		public Movie GetMovie(@PathVariable Long movieId)
		{
				//get isteği int parametre ile beraber yapıldığında çalışacak alandır.url localhost:8080/movies/id şeklinde get isteği şeklinde olmalıdır.id değeri int değeri olmalıdır.
				//casts için arraylist oluşturuldu ve add fonksiyonu ile caste eklemeler yapıldı.Gelen id değeri movie id olacak şekilde ayarlandı.
				Genre[] genres = Genre.values();					
				int randomIndex = new Random().nextInt(genres.length);
				ArrayList<String> casts= new ArrayList<String>();
				casts.add("name1");
				casts.add("name2");
				casts.add("name3");
				casts.add("name4");
				casts.add("name5");
				casts.add("name6");
				casts.add("name7");
				casts.add("name8");
				casts.add("name9");
				casts.add("name10");
				return Movie.builder()
					.movieId(movieId)
					.name("movie" + String.valueOf(movieId))
					.genre(genres[randomIndex])
					.releaseYear(2020)
					.directorName("directorname" + String.valueOf(movieId) )
					.cast(casts)
					.build();
		}
		
		@DeleteMapping("/moviesdelete/{movieId}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void DeleteMovie(@PathVariable Long movieId)
		{
			//delete isteği yapıldığında çalışacak alandır.url localhost:8080/moviesdelete/id şeklinde olmalıdır.id değeri int değer olmalıdır.

		}
}
