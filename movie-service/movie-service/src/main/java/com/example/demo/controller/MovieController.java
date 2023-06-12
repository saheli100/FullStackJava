package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.exception.MyCustomException;
import com.example.demo.service.MovieService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
	   private final MovieService movieService;
	   
	   @PostMapping
		public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
			return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movie));
		}
	   @GetMapping
		public ResponseEntity<List<Movie>> getAllMovies() {
			return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies());
		}
	   @GetMapping("/{id}")
		public ResponseEntity<Movie> FindMovieByMovieId(@PathVariable Integer id) {
		   Movie findByMovieId = movieService.findByMovieId(id);
		   if(findByMovieId == null)
			   throw new MyCustomException("Movie With id " + id + " nt found");
		   else
			   return ResponseEntity.status(HttpStatus.FOUND).body(findByMovieId);
		}
	   @DeleteMapping("/{id}")
		public ResponseEntity<Integer> DeleteMovieByMovieId(@PathVariable Integer id) {
		   
			   return ResponseEntity.status(HttpStatus.OK).body(movieService.deleteByMovieId(id));
		}
	   @PutMapping("/{id}")
		public ResponseEntity<Movie> updateUserById(@PathVariable("id") int id,
				@RequestBody Movie movie) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(movieService.updateMovieDetailsById(id, movie));
		}

}
