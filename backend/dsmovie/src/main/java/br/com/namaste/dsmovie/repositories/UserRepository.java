package br.com.namaste.dsmovie.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.namaste.dsmovie.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
