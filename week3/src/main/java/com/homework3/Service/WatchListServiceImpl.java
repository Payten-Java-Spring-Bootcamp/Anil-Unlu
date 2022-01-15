package com.homework3.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.homework3.Dao.WatchListDao;
import com.homework3.Model.WatchList;

@Service
public class WatchListServiceImpl implements WatchListService{

	@Autowired
	private WatchListDao watchListDao;

	public WatchList Create(WatchList watchList) {
		return watchListDao.Create(watchList);
	}

	@Override
	public WatchList Update(Long id, WatchList watchList) {
		 return watchListDao.Update(id, watchList);
	}

	@Override
	public WatchList Retrieve(Long id) {
		 return watchListDao.Retrieve(id);
	}

	@Override
	public List<WatchList> RetrieveAll() {
		return watchListDao.RetrieveAll();
	}

	@Override
	public void Remove(Long id) {
		watchListDao.Remove(id);
	}
	
	
	
	
}
