package com.homework2;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Member {
	
		private long memberId;
		private int movieId;
		private double point;
}
