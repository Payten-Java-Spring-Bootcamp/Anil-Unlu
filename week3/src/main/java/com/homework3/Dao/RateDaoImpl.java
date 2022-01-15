package com.homework3.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework3.Model.RateEntity;
import com.homework3.Repository.RateJpaRepository;
import com.homework3.Service.Rate;

@Service
public class RateDaoImpl implements RateDoa{

	@Autowired
	private RateJpaRepository rateJpaRepository;
		
	public void RateToMovie(RateEntity rateEntity) {
		rateJpaRepository.save(rateEntity);
	}

	@Override
	public List<RateEntity> Retrieve(Long movieId) {
		return rateJpaRepository.Retrieve(movieId);
	}
	
	

}
