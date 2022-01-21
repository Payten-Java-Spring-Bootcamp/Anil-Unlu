package com.homework3.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.homework3.Model.WatchList;

@Repository
public class RedisDao {

	public static final String HASH_KEY = "WatchListRedis";
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public WatchList CreateWithRedis(WatchList watchList){
		redisTemplate.opsForHash().put(HASH_KEY,watchList.getId(),watchList);
		return watchList;
	}
	
	public WatchList RetrieveWithRedis(Long id) {
		 return (WatchList) redisTemplate.opsForHash().get(HASH_KEY,id);
	}
	public List<WatchList> RetrieveAllWithRedis(){
		  return redisTemplate.opsForHash().values(HASH_KEY);
	}
	public String RemoveWithRedis(Long id) {
		 redisTemplate.opsForHash().delete(HASH_KEY,id);
	        return "Deleted id : " + String.valueOf(id);
	}
	
}
