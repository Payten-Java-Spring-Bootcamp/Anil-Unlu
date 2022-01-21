package com.homework3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.homework3.Model.Movie;
import com.homework3.Service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
public class MovieController {

	@Autowired
	private  MovieService movieService;
	
	@PostMapping("/movies")
	@ResponseStatus(HttpStatus.CREATED)
	public Movie Create(@RequestBody Movie movie)
	{
		return movieService.Create(movie);
	}
	
	@GetMapping("/movies/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Movie> Retrieve(@PathVariable Long id){
		return movieService.Retrieve(id);
	}
	
	@DeleteMapping("/movies/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String Remove(@PathVariable Long id) {
		movieService.Remove(id);
		return "Deleted movieId : " + String.valueOf(id);
	}
	
	@PutMapping("/movies/{id}")
	public Movie Update(@PathVariable Long id, @RequestBody Movie movie) {
		return movieService.Update(id, movie);
	}
	
	@GetMapping("/movies")
	@ResponseStatus(HttpStatus.OK)
	public List<Movie> RetrieveAll(){
		return movieService.RetrieveAll();
	}
}
