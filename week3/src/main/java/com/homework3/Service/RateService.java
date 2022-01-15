package com.homework3.Service;

import java.util.List;


public interface RateService {
	
	void RateToMovie(Rate rate);
	
	List<Rate> Retrieve(Long id);
}
