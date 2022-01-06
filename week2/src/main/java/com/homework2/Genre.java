package com.homework2;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
	//postmanden jsonpropertyde yazan değerlerle genre değerini set etmelisiniz.
	@JsonProperty("ScienceFiction")
	Sciencfiction,
	@JsonProperty("Comedy")
	Comedy,
	@JsonProperty("Dram")
	Dram,
	@JsonProperty("Thriller")
	Thriller;
}
