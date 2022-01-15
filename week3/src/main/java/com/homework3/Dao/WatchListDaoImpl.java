package com.homework3.Dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.homework3.Model.WatchList;
import com.homework3.Repository.WatchListJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WatchListDaoImpl implements WatchListDao{

	@Autowired
	private WatchListJpaRepository watchListJpaRepository;
	
	@Autowired
	private final RedisDao redisDao;
	
	public WatchList Create(WatchList watchList) {
		return watchListJpaRepository.save(watchList); 
	}


	@Override
	public WatchList Update(Long id, WatchList watchList) {
		
		WatchList existedWatchList = null;
		try {
			existedWatchList = watchListJpaRepository.findById(id).orElseThrow(()-> new RuntimeException());
		} catch (Exception e) {
			e.printStackTrace();
		}
		existedWatchList.setMemberId(watchList.getMemberId());
		existedWatchList.setMovieId(watchList.getMovieId());
		watchListJpaRepository.save(existedWatchList);
		return existedWatchList;
	}


	@Override
	public WatchList Retrieve(Long id) {
		 Optional<WatchList> watchlist = watchListJpaRepository.findById(id);
		 if(watchlist.isPresent()) {
		 	return watchlist.get();
		 }
		 else {
			throw new RuntimeException();
		}
	}


	@Override
	public List<WatchList> RetrieveAll() {
		return watchListJpaRepository.findAll();
	}


	@Override
	public void Remove(Long id) {
		Optional<WatchList> watchList = watchListJpaRepository.findById(id);
		if(watchList.isPresent()) {
			watchListJpaRepository.deleteById(id);
		}
		else {
			throw new RuntimeException();
		}
		
	}
	

}
