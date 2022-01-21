package com.homework3.Controller;

import java.util.List;
import java.util.Map;

import javax.persistence.Cache;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.*;

import com.homework3.Dao.RedisDao;
import com.homework3.Model.WatchList;
import com.homework3.Redis.Redis;
import com.homework3.Service.WatchListService;

@RestController
public class WatchListController {

	@Autowired
	private WatchListService watchListService;
	 
	@Autowired
	private RedisDao redisDao;
	
	@PostMapping("/WatchList")
	@ResponseStatus(HttpStatus.CREATED)
	public WatchList Create(@RequestBody WatchList watchList) {
		return watchListService.Create(watchList);
	}
	
	@PutMapping("/WatchList/{watchListId}")
	@ResponseStatus(HttpStatus.OK)
	public WatchList Update(@PathVariable Long watchListId,@RequestBody WatchList watchList) {
		return watchListService.Update(watchListId, watchList);
	}
	
	@GetMapping("/WatchList/{id}")
	@ResponseStatus(HttpStatus.OK)
	public WatchList Retrieve(@PathVariable Long id) {
		return watchListService.Retrieve(id);
	}
	
	@GetMapping("/WatchList")
	@ResponseStatus(HttpStatus.OK)
	public List<WatchList> RetrieveAll(){	 
		return watchListService.RetrieveAll();
	}
	
	
	@DeleteMapping("/WatchList/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String Remove(@PathVariable Long id) {
			watchListService.Remove(id);
			return "Deleted id : " + String.valueOf(id);
	}
	
	
	@PostMapping("/WatchListRedis")
	public WatchList CreateWithRedis(@RequestBody WatchList watchList){
		return  redisDao.CreateWithRedis(watchList);
	}
	
	@GetMapping("/WatchListRedis/{id}")
	@Cacheable(key = "#id",value = "WatchListRedis")
	public WatchList RetrieveWithRedis(@PathVariable Long id){
		 return redisDao.RetrieveWithRedis(id);
	}
	
	@GetMapping("/WatchListAllRedis")
	public List<WatchList> RetrieveAllWithRedis(){
		  return redisDao.RetrieveAllWithRedis();
	}
	
	@DeleteMapping("/WatchListDeleteRedis/{id}")
	@CacheEvict(key = "#id",value = "WatchListRedis")
	public String RemoveWithRedis(Long id) {
	        return redisDao.RemoveWithRedis(id);
	}
	
	
	
	
	
}
