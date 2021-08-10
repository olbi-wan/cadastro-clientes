package br.com.platformbuilders.cadastroclientes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.platformbuilders.cadastroclientes.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(final String email);

}