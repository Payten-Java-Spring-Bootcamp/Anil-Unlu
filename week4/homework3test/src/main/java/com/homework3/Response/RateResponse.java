package com.homework3.Response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.homework3.Service.Rate;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RateResponse {

	private LocalDateTime createdDateTime;
	private Long memberId;
	private Long movieId;
	private Integer point;
	
	public static List<RateResponse> convertFromRate(List<Rate> rateList){
		return rateList.stream()
				.map(RateResponse::convertFromRate)
				.collect(Collectors.toList());
	}
	
	public static RateResponse convertFromRate(Rate rate) {
		return RateResponse.builder()
				.createdDateTime(rate.getCreatedDateTime())
				.memberId(rate.getMemberId())
				.movieId(rate.getMovieId())
				.point(rate.getPoint())
				.build();
	}
	
}
