package com.homework3.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.homework3.Model.Movie;
import com.homework3.Model.RateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Rate{
	
	private Long movieId;
	private Long memberId;
	private Integer point;
	private LocalDateTime createdDateTime;
	
	public RateEntity RateToRateEntity(Movie movie){
		RateEntity rateEntity = new RateEntity();
		rateEntity.setCreatedDateTime(LocalDateTime.now());
		rateEntity.setMemberId(memberId);
		rateEntity.setMovie(movie);
		rateEntity.setPoint(point);
		return rateEntity;
		
	}
	
	public static Rate convertFromRateEntity(RateEntity rateEntity) {
		return Rate.builder()
				.createdDateTime(rateEntity.getCreatedDateTime())
				.memberId(rateEntity.getMemberId())
				.movieId(rateEntity.getMovie().getId())
				.point(rateEntity.getPoint())
				.build();
	}

	



}

	

