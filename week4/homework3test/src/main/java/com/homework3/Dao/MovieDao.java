package com.homework3.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homework3.Model.Movie;

public interface MovieDao {
	Movie Create(Movie movie);
	Movie Retrieve(Long id);
	void Remove(Long id);
	Movie Update(Long id,Movie movie);
	List<Movie> RetrieveAll();
	
	
}
