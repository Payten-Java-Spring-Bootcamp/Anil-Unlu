package com.homework2;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class WatchList {

		private int memberId;
		private List<String> watchListName;
}
