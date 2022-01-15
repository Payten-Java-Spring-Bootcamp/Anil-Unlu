package com.homework3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.homework3.Model.WatchList;

@Repository
public interface WatchListJpaRepository extends JpaRepository<WatchList, Long> {
	
}
