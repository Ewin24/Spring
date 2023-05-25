package com.crud.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.app.entity.Cliente;
import com.crud.app.repository.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienterepository;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienterepository.findAll();
	}

	@Override
	public void save(Cliente cliente) {

		clienterepository.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente FindOne(Long id) {
		// TODO Auto-generated method stub
		return clienterepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		clienterepository.deleteById(id);
	}

}
