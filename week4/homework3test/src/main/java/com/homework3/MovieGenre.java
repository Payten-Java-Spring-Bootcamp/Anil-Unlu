package com.homework3;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MovieGenre {
	@JsonProperty("Action")
	ACTION,
	@JsonProperty("Horror")
	HORROR,
	@JsonProperty("Drama")
	DRAMA,
	@JsonProperty("Comedy")
	COMEDY,
	@JsonProperty("Romance")
	ROMANCE,
	@JsonProperty("ScienceFiction")
	SCI_FI

}
