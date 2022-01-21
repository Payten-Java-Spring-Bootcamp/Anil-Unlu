package com.homework2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	
	
	@PostMapping("/givepoint")
	@ResponseStatus(HttpStatus.CREATED)
	public Member GivePoint(@RequestBody Member member)
	{
		//post isteği yapıldığında çalışacak alandır.url localhost:8080/givepoint şeklinde olmalı ve post isteği ile birlikte body içerisinde json parametreleri,memberId,movieId ve point değeleri yazılı olarak gönderilmelidir.
		return Member.builder()
				.memberId(member.getMemberId())
				.movieId(member.getMovieId())
				.point(member.getPoint())
				.build();
	}
	
	@PostMapping("/watchlist")
	@ResponseStatus(HttpStatus.CREATED)
	public WatchList MakeWatchList(@RequestBody WatchList watchlist)
	{
		//post isteği yapıldığında çalışacak alandır.url localhost:8080/watchlist şeklinde olmalı ve post isteği ile birlite body içerisinde json parametreleri memberId ve watchListName arrayi yazılarak gönderilmelidir.
		return WatchList.builder()
				.memberId(watchlist.getMemberId())
				.watchListName(watchlist.getWatchListName())
				.build();
	}
	
	@PostMapping("/addmovie")
	@ResponseStatus(HttpStatus.CREATED)
	public AddMovie AddMovies(@RequestBody AddMovie addMovie)
	{
		//post isteği yapıldığında çalışacak alandır.url localhost:8080/addmovie şeklinde olmalı post isteği ile birlikte body içerisinide json parametreleri,watchListId ve movieId değerleri yazılarak gönderilmelidir.
		return AddMovie.builder()
				.watchListId(addMovie.getWatchListId())
				.movieId(addMovie.getMovieId())
				.build();
	}

}
