package br.com.namaste.dsmovie.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.namaste.dsmovie.dtos.MovieDTO;
import br.com.namaste.dsmovie.models.Movie;
import br.com.namaste.dsmovie.repositories.MovieRepository;
import br.com.namaste.dsmovie.services.MovieService;

@Service("MovieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Override
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> result = movieRepository.findById(id);
		
		if (result.isPresent()) {
			MovieDTO dto = new MovieDTO(result.get());
			return dto;
		}
		return null;
	}
}
