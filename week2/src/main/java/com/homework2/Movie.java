package com.homework2;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.inferred.freebuilder.FreeBuilder;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Movie{

		private long movieId;
		private String name;
		public Genre genre;
		private int releaseYear;
		private String directorName;
		private List<String> cast;
		
		
		
}
