package com.homework3;

import static org.assertj.core.api.Assertions.assertThat;
import com.homework3.Repository.WatchListJpaRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import com.homework3.Model.WatchList;
import java.util.List;

public class WatchListIntegrationTest extends BaseIntegrationTest {

	@Autowired
	WatchListJpaRepository watchListJpaRepository;


	@Test
	public void should_create_watchList() {

		//given
		WatchList watchList = new WatchList();
		watchList.setMemberId("60");
		watchList.setMovieId(2L);

		//when
		ResponseEntity<WatchList> response = testRestTemplate.postForEntity("/WatchList", watchList, WatchList.class);

		//Then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();


	}

	@Test
	public void deleteWatchListByIdTest() {

		//given
		WatchList watchList = new WatchList();
		watchList.setMemberId("20");
		watchList.setMovieId(200L);
		watchList.setId(20L);

		//when
		watchListJpaRepository.save(watchList);
		watchListJpaRepository.delete(watchList);

		//then
		assertThat(watchListJpaRepository.existsById(20L)).isFalse();

	}

	@Test
	@Sql(scripts = "/watchlistFindById.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "/watchListDeleteById.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void should_Get_Watchlist_ById(){

		//given
		ResponseEntity<WatchList> response;
		ResponseEntity<WatchList> response2;

		//when
		response = testRestTemplate.getForEntity("/WatchList/81", WatchList.class);
		response2 = testRestTemplate.getForEntity("/WatchList/80", WatchList.class);

		//then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getMemberId()).isEqualTo("4");
		assertThat(response.getBody().getMovieId()).isEqualTo(6);


		assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response2.getBody()).isNotNull();
		assertThat(response2.getBody().getId()).isNotNull();
		assertThat(response2.getBody().getMovieId()).isEqualTo(2);
		assertThat(response2.getBody().getMemberId()).isEqualTo("2");
	}

}
