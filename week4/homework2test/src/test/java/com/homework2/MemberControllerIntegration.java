package com.homework2;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberControllerIntegration extends BaseIntegration{

    @Test
    public void should_Create_Watch_list(){

        //given
        List<String> watchListNames = new ArrayList<>();
        watchListNames.add("watchListName1");
        watchListNames.add("watchlistName2");
        WatchList watchList = WatchList.builder()
                .memberId(2)
                .watchListName(watchListNames)
                .build();

        //when

        ResponseEntity<WatchList> response = testRestTemplate.postForEntity("/watchlist", watchList, WatchList.class);

        //then

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getMemberId()).isEqualTo(2);
        assertThat(response.getBody().getWatchListName()).isEqualTo(watchListNames);

    }

    @Test
    public void should_Create_GivePoint(){

        //given
        Member member = Member.builder()
                .point(4)
                .movieId(1)
                .memberId(2)
                .build();

        //when
        ResponseEntity<Member> response = testRestTemplate.postForEntity("/givepoint", member, Member.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getPoint()).isEqualTo(4);
        assertThat(response.getBody().getMemberId()).isEqualTo(2);
        assertThat(response.getBody().getMovieId()).isEqualTo(1);

    }

    @Test
    public void should_Create_AddMovie(){

        //given
        AddMovie addMovie = AddMovie.builder()
                .movieId(2)
                .watchListId(4)
                .build();

        //when
        ResponseEntity<AddMovie> response = testRestTemplate.postForEntity("/addmovie", addMovie, AddMovie.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat((response.getBody().getMovieId())).isEqualTo(2);
        assertThat(response.getBody().getWatchListId()).isEqualTo(4);

    }

}
