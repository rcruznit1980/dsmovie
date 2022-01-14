package br.com.namaste.dsmovie.services;

import br.com.namaste.dsmovie.dtos.MovieDTO;
import br.com.namaste.dsmovie.dtos.ScoreDTO;

public interface ScoreService {

	MovieDTO saveScore(ScoreDTO dto);

}
