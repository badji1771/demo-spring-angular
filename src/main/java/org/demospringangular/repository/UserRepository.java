package org.demospringangular.repository;

import java.util.List;
import java.util.Optional;

import org.demospringangular.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String name);

	Optional<User> findByEmail(String email);

}
