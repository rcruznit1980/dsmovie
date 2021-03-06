package br.com.namaste.dsmovie.services.implementations;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.namaste.dsmovie.dtos.MovieDTO;
import br.com.namaste.dsmovie.dtos.ScoreDTO;
import br.com.namaste.dsmovie.models.Movie;
import br.com.namaste.dsmovie.models.Score;
import br.com.namaste.dsmovie.models.User;
import br.com.namaste.dsmovie.repositories.MovieRepository;
import br.com.namaste.dsmovie.repositories.ScoreRepository;
import br.com.namaste.dsmovie.repositories.UserRepository;
import br.com.namaste.dsmovie.services.ScoreService;

@Service("ScoreService")
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Override
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());

		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);

		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size(); 
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
