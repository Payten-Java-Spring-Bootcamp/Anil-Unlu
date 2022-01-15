package com.homework3.Repository;

import org.springframework.stereotype.Repository;
import com.homework3.Model.Movie;

@Repository
public interface JpaRepository extends  org.springframework.data.jpa.repository.JpaRepository<Movie, Long>{

}
