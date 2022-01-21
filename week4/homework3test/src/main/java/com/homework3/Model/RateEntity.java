package com.homework3.Model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Data
@Entity(name = "rateEntity")
@Table(name = "rate")
public class RateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long memberId;
	
	@Column(nullable = false)
	private LocalDateTime createdDateTime;
	
	@Column(nullable = false)
	private Integer point;
	
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Movie movie;

	
}
