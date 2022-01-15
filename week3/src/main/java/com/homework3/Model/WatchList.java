package com.homework3.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Entity(name = "watchList")
@Table(name = "watch_list")
@Data
public class WatchList implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String memberId;
	
	@Column(nullable = false)
	private ArrayList<Long> movieId;
	
}
