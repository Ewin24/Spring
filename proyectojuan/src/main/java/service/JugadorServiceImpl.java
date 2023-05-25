package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.trabajo1.app.entidades.Jugador;
import repository.IJugadoresRepository;

public class JugadorServiceImpl implements IJugadorService {
	
	@Autowired
	private IJugadoresRepository jugadorRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Jugador> findAll() {
		// TODO Auto-generated method stub
		return (List<Jugador>) jugadorRepository.findAll();
	}

	@Override
	public void save(Jugador jugador) {
		jugadorRepository.save(jugador);
	}

	@Override
	@Transactional(readOnly = true)
	public Jugador FindOne(Long id) {
		
		return jugadorRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		jugadorRepository.deleteById(id);
	}

}
