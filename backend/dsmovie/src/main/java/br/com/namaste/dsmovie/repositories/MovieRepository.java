package br.com.namaste.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.namaste.dsmovie.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
