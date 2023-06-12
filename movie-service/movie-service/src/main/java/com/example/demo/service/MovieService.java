package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Movie;

public interface MovieService {
	public Movie addMovie(Movie movie);
	
	public List<Movie> getAllMovies();
	
	public Movie findByMovieId(int movieId);
	
	public Integer deleteByMovieId(int movieId);
	
	public Movie updateMovieDetailsById(int id,Movie movie);
}
