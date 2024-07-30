package org.demospringangular.repository;


import org.demospringangular.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VilleRepository extends JpaRepository<Ville, Long> {
}
