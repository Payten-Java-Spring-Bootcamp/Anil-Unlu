package com.homework3.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.homework3.Model.Movie;

@Service
public class MovieDaoImpl implements MovieDao{

	@Autowired
	private JpaRepository jpaRepository;
	
	public Movie Create(Movie movie) {
		return (Movie) jpaRepository.save(movie);
	}

	public Movie Retrieve(Long id) {
		Optional<Movie> movie = jpaRepository.findById(id);
		
		if(movie.isPresent()) {			
			return movie.get();
		}
		else {
			throw new RuntimeException();
		}

	}

	
	public void Remove(Long id) {
		Optional<Movie> movie = jpaRepository.findById(id);
		if(movie.isPresent()) {
			jpaRepository.deleteById(id);
		}
		else {
			throw new RuntimeException();
		}
	}

	
	public Movie Update(Long id, Movie movie) {
		Movie existingMovie = null;
		try {
			existingMovie = (Movie) jpaRepository.findById(id).orElseThrow(()-> new RuntimeException());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		existingMovie.setDirector(movie.getDirector());
		existingMovie.setGenre(movie.getGenre());
		existingMovie.setName(movie.getName());
		existingMovie.setReleaseYear(movie.getReleaseYear());
		jpaRepository.save(existingMovie);
		return existingMovie;
	}

	
	public List<Movie> RetrieveAll() {
		 return jpaRepository.findAll();
	}


	
}
