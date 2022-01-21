package com.homework3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.homework3.Model.Movie;

public interface MovieService {

	 Movie Create(Movie movie);
	 Optional<Movie> Retrieve(Long id);
	 void Remove(Long id);
	 Movie Update(Long id, Movie movie);
	 List<Movie> RetrieveAll();
	
}
