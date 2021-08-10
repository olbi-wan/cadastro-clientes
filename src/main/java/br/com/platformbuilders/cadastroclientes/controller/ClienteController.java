package br.com.platformbuilders.cadastroclientes.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.platformbuilders.cadastroclientes.business.ClienteBusiness;
import br.com.platformbuilders.cadastroclientes.model.Cliente;
import br.com.platformbuilders.cadastroclientes.model.Endereco;
import br.com.platformbuilders.cadastroclientes.model.Usuario;
import lombok.RequiredArgsConstructor;

/**
 * <p>API responsavel pelo {@link Cliente} vinculado ao {@link Usuario}.</p>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteBusiness business;

    /**
     * <p>Veja {@link ClienteBusiness#atualizar(Cliente)}.</p>
     * <i>{{cadastro-cliente}}/cliente</i>
     * @param cliente dados do {@link Cliente}
     */
    @PutMapping
    public void atualizar(@RequestBody Cliente cliente) {
        business.atualizar(cliente);
    }

    /**
     * <p>Veja {@link ClienteBusiness#cadastrar(Cliente)}.</p>
     * <i>{{cadastro-cliente}}/cliente</i>
     * @param usuarioId ID do {@link Usuario} = ID do {@link Cliente}
     * @param cliente dados do {@link Cliente}
     * @return {@link Cliente} com ID
     */
    @PostMapping("/{usuarioId}")
    public Cliente cadastrar(@PathVariable long usuarioId, @RequestBody Cliente cliente) {
        return business.cadastrar(usuarioId, cliente);
    }

    /**
     * <p>Veja {@link ClienteBusiness#atualizarEnderecoEntrega(long, Endereco)}.</p>
     * <i>{{cadastro-cliente}}/cliente</i>
     * @param usuarioId ID do {@link Usuario} = ID do {@link Cliente}
     * @param cliente dados do {@link Cliente}
     */
    @PatchMapping("/{usuarioId}")
    public void atualizarEnderecoEntrega(@PathVariable long clienteId, @RequestBody Endereco entrega) {
        business.atualizarEnderecoEntrega(clienteId, entrega);
    }

}