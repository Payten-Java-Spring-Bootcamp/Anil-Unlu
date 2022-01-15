package com.homework3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.homework3.Dao.MovieDao;
import com.homework3.Model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDao movieDao;
	
	public Movie Create(Movie movie)
	{
		return	movieDao.Create(movie);
	}

	public Optional<Movie> Retrieve(Long id) {
		return Optional.ofNullable(movieDao.Retrieve(id));
	}

	
	public void Remove(Long id){
		 movieDao.Remove(id);
	}

	public Movie Update(Long id, Movie movie) {
		 return movieDao.Update(id, movie);
	}
	
	public List<Movie> RetrieveAll(){
		return movieDao.RetrieveAll();
	}

}
