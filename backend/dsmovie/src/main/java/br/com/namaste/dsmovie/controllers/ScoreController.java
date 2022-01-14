package br.com.namaste.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.namaste.dsmovie.dtos.MovieDTO;
import br.com.namaste.dsmovie.dtos.ScoreDTO;
import br.com.namaste.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		
		MovieDTO movieDto = scoreService.saveScore(dto);
		
		return movieDto;
	}
}
