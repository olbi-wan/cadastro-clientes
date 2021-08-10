package br.com.platformbuilders.cadastroclientes.business;

import org.springframework.stereotype.Component;

import br.com.platformbuilders.cadastroclientes.exception.CadastroException;
import br.com.platformbuilders.cadastroclientes.model.Usuario;
import br.com.platformbuilders.cadastroclientes.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

/**
 * <p>Regra de negocio responsavel pelo {@link Usuario}.</p>
 */
@RequiredArgsConstructor
@Component
public class UsuarioBusiness {

    private final UsuarioRepository repository;

    /**
     * <p>Cadastro de usuario.</p>
     * @param usuario dados do {@link Usuario}
     * @return {@link Usuario} com ID
     */
    public Usuario cadastrar(final Usuario usuario) {
        repository.findByEmail(usuario.getEmail()).ifPresent(duplicado ->  { throw new CadastroException("Usuário duplicado."); });
        return repository.save(usuario);
    }

    /**
     * <p>Troca a senha atual do usuario.</p>
     * @param id ID do {@link Usuario}
     * @param atual senha do {@link Usuario}
     * @param nova senha do {@link Usuario}
     */
    public void trocarSenha(final long id, final String atual, final String nova) {

    	// Usuario nao encontrado.
        final var usuario = repository.findById(id).orElseThrow(() -> { throw new CadastroException("Usuário inexistente."); });

        // Senha atual do usuario informada invalida.
        if(!usuario.isValida(atual)) throw new CadastroException("Senha inválida.");

        usuario.setSenha(nova);

    }

}