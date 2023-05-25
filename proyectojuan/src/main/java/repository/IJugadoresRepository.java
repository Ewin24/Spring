package repository;

import org.springframework.data.repository.CrudRepository;

import com.trabajo1.app.entidades.Jugador;

public interface IJugadoresRepository extends CrudRepository<Jugador, Long> {

}
