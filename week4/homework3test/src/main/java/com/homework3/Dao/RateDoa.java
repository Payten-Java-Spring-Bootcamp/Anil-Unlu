package com.homework3.Dao;

import java.util.List;

import com.homework3.Model.RateEntity;
import com.homework3.Service.Rate;

public interface RateDoa {
	
	void RateToMovie(RateEntity rateEntity);
	
	List<RateEntity> Retrieve(Long movieId);
	
}
