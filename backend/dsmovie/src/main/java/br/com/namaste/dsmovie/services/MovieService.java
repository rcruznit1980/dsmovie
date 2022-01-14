package br.com.namaste.dsmovie.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.namaste.dsmovie.dtos.MovieDTO;

public interface MovieService {

	Page<MovieDTO> findAll(Pageable pageable);

	MovieDTO findById(Long id);

}
