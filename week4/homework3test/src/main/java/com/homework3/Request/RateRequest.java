package com.homework3.Request;

import javax.validation.constraints.NotNull;

import com.homework3.Service.Rate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RateRequest {

	@NotNull
	private Long memberId;
	@NotNull
	private Long movieId;
	@NotNull
	private Integer point;
	
	public Rate RateRequestToRate(){
		return Rate.builder()
				.memberId(memberId)
				.movieId(movieId)
				.point(point)
				.build();
	}
	
	
	
}
