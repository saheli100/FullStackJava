package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Movie;
import com.example.demo.entity.MovieUsers;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	@Transactional
	@Modifying
	@Query("DELETE FROM Movie WHERE movie_id = :movieId")
	public Integer deleteByMovieId(int movieId);

}
