package service;

import java.util.List;

import com.trabajo1.app.entidades.Jugador;

public interface IJugadorService {
	public List<Jugador> findAll();

	public void save(Jugador jugador);

	public Jugador FindOne(Long id);

	public void delete(Long id);

}
