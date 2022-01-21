package com.homework3.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.stereotype.Service;

import com.homework3.Model.Movie;
import com.homework3.Model.RateEntity;
import com.homework3.Dao.*;

import lombok.RequiredArgsConstructor;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private  MovieDao movieDao;
	
	@Autowired
	private  RateDoa rateDao;
	
	public void RateToMovie(Rate rate){
		Movie movie = movieDao.Retrieve(rate.getMovieId());
		RateEntity rateEntity = rate.RateToRateEntity(movie);
		
		rateDao.RateToMovie(rateEntity);
		
	}

	public List<Rate> Retrieve(Long id) {
		return rateDao.Retrieve(id)
				.stream()
				.map(Rate::convertFromRateEntity)
				.collect(Collectors.toList());
		
	}
	
}
