package com.homework3.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.homework3.MovieGenre;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private MovieGenre genre;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "releaseYear")
	private Integer releaseYear;
	
	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
	private List<RateEntity> rates;
	
	
}
