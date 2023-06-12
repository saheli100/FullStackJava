package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "genre")
	@Enumerated(EnumType.STRING)
	private GENRE_TYPE genre;

    
    //@ManyToOne(fetch=FetchType.LAZY)  
   // private MovieUsers movieUsers;  
}