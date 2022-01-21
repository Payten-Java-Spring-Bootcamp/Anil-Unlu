package com.homework3.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import com.homework3.Model.WatchList;

public interface WatchListDao {
	
	WatchList Create(WatchList watchList);
	WatchList Update(Long id, WatchList watchList);
	WatchList Retrieve(Long id);
	List<WatchList> RetrieveAll();
	void Remove(Long id);
	
}
