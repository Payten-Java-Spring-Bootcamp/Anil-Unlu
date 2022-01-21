package com.homework3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homework3.Model.RateEntity;

@Repository
public interface RateJpaRepository extends JpaRepository<RateEntity, Long>{

		@Query(value = "Select r from rateEntity as r Where r.movie.id = :movieId")
		List<RateEntity> Retrieve(@Param("movieId") Long movieId);
}
