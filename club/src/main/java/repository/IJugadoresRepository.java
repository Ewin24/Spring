package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Jugador;

public interface IJugadoresRepository extends CrudRepository<Jugador, Long> {

}
