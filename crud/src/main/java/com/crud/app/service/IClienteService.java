package com.crud.app.service;

import java.util.List;

import com.crud.app.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void save (Cliente cliente);
	
	public Cliente FindOne(Long id);
	
	public void delete(Long id);

}
