package com.homework3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.homework3.Service.Rate;
import com.homework3.Service.RateService;
import com.homework3.Request.RateRequest;
import com.homework3.Response.RateResponse;

@RestController
public class RateController {
	
	@Autowired
	private RateService rateService;
	
	@PostMapping("/rate")
	@ResponseStatus(HttpStatus.CREATED)
	public void Rate(@RequestBody RateRequest request) {
		 Rate rate = request.RateRequestToRate();
		 rateService.RateToMovie(rate);
	}
	
	@GetMapping("/rates")
	@ResponseStatus(HttpStatus.OK)
	public List<RateResponse> Retrieve(@RequestParam Long movieId){
		List<Rate> rateList = rateService.Retrieve(movieId);
		return RateResponse.convertFromRate(rateList);
	}

}
