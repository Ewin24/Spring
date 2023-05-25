package models.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.entities.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao{
	@PersistenceContext
	private EntityManager em;
	@SuppressWarnings("unchecked")

	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	} 
}
