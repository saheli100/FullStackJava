package com.example.demo.entity;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "movie_users")
public class MovieUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;

	
	  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	  @JoinTable(name = "movieuser_movieroles", joinColumns = @JoinColumn(name = "movie_users_id",
	  referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name =
	  "role_id", referencedColumnName = "id"))
	 
	  private Set<Role> roles;
	 
    //@OneToMany(mappedBy="movie_users")  
    //private List<Movie> movies;   
}