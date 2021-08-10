package br.com.platformbuilders.cadastroclientes.business;

import org.springframework.stereotype.Component;

import br.com.platformbuilders.cadastroclientes.exception.CadastroException;
import br.com.platformbuilders.cadastroclientes.model.Cliente;
import br.com.platformbuilders.cadastroclientes.model.Endereco;
import br.com.platformbuilders.cadastroclientes.model.Usuario;
import br.com.platformbuilders.cadastroclientes.repository.ClienteRepository;
import br.com.platformbuilders.cadastroclientes.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClienteBusiness {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;
    
    /**
     * <p>Atualiza os dados do {@link Cliente}.</p>
     * @param cliente dados do {@link Cliente}
     */
    public void atualizar(final Cliente cliente) {

        // O ID do {@link Cliente} eh igual ao ID do {@link Usuario}.
        if(!clienteRepository.existsById(cliente.getId())) throw new CadastroException("Cliente inexistente.");

        // Atualiza os dados do {@link Cliente}.
        clienteRepository.save(cliente);

    }

    /**
     * <p>Cadastra os dados do {@link Cliente} vinculado ao {@link Usuario}.</p>
     * @param usuarioId ID do {@link Usuario} = ID do {@link Cliente}
     * @param cliente dados do {@link Cliente}
     * @return {@link Cliente} com ID
     */
    public Cliente cadastrar(final long usuarioId, final Cliente cliente) {

        // Vincula o usuario ao cliente.
        final var usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> { throw new CadastroException("Usuário inexistente."); });
        cliente.setUsuario(usuario);

        return clienteRepository.save(cliente);

    }

    /**
     * <p>Atualiza o {@link Endereco} de entrada do cliente.</p>
     * @param usuarioId ID do {@link Usuario} = ID do {@link Cliente}
     * @param cliente dados do {@link Cliente}
     */
    public void atualizarEnderecoEntrega(final long clienteId, final Endereco entrega) {

        // O ID do {@link Cliente} eh igual ao ID do {@link Usuario}.
        final var cliente = clienteRepository.findById(clienteId).orElseThrow(() -> { throw new CadastroException("Cliente inexistente."); });

        cliente.addEnderecoEntrega(entrega);

    }

}