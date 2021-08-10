package br.com.platformbuilders.cadastroclientes.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.platformbuilders.cadastroclientes.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {}