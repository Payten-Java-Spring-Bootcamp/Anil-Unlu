package com.homework3.Service;

import java.util.List;
import java.util.Map;

import com.homework3.Model.WatchList;

public interface WatchListService {
	WatchList Create(WatchList watchList);
	WatchList Update(Long id, WatchList watchList);
	WatchList Retrieve(Long id);
	List<WatchList> RetrieveAll();
	void Remove(Long id);
}
