package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
	private final MovieRepository movieRepository;

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public Movie findByMovieId(int movieId) {
		// TODO Auto-generated method stub
		Movie movie = null;
		List<Movie> movieList = getAllMovies();
		for (Movie m : movieList) {
			if (m.getMovieId() == (movieId)) {
				movie = m;
				
				break;
			}
		}
		return movie;
	}

	@Override
	
	public Integer deleteByMovieId(int movieId) {
		// TODO Auto-generated method stub		
		return movieRepository.deleteByMovieId(movieId);
	}

	@Override
	public Movie updateMovieDetailsById(int id, Movie movie) {
		// TODO Auto-generated method stub
		Movie savedMovie = null;
		Movie movieEntityFromDb = findByMovieId(id);
		if (!(movieEntityFromDb== null)) {
			
			movieEntityFromDb.setMovieId(movie.getMovieId());
			movieEntityFromDb.setMovieName(movie.getMovieName());
			movieEntityFromDb.setGenre(movie.getGenre());
			 savedMovie = movieRepository.save(movieEntityFromDb);
		}
		return savedMovie;
	}

}
