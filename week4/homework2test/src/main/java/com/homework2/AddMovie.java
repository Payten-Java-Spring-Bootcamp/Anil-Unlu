package com.homework2;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddMovie {
	
	private int watchListId;
	private int movieId;
}
