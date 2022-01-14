package br.com.namaste.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.namaste.dsmovie.models.Score;
import br.com.namaste.dsmovie.models.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {

}
