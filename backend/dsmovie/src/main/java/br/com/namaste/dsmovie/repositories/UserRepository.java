package br.com.namaste.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.namaste.dsmovie.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}