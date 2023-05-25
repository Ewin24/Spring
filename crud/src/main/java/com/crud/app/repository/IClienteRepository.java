package com.crud.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.app.entity.Cliente;

public interface IClienteRepository  extends CrudRepository<Cliente, Long>{

}
