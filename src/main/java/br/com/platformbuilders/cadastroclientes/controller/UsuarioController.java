package br.com.platformbuilders.cadastroclientes.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.platformbuilders.cadastroclientes.business.UsuarioBusiness;
import br.com.platformbuilders.cadastroclientes.model.Usuario;
import lombok.RequiredArgsConstructor;

/**
 * <p>API responsavel pelo {@link Usuario}.</p>
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioBusiness business;

    /**
     * <p>Veja {@link UsuarioBusiness#cadastrar(Usuario)}.</p>
     * <i>{{cadastro-cliente}}/usuario</i>
     * @param usuario dados do {@link Usuario}
     * @return {@link Usuario} com ID
     */
    @PostMapping
    public Usuario cadastrar(@Valid @RequestBody Usuario usuario) {
        return business.cadastrar(usuario);
    }

    /**
     * <p>Veja {@link UsuarioBusiness#trocarSenha(long, String, String)}.</p>
     * <i>{{cadastro-cliente}}/usuario/{{id}}</i>
     * @param id ID do {@link Usuario}
     * @param atual senha do {@link Usuario}
     * @param nova senha do {@link Usuario}
     */
    @PatchMapping("/{id}")
    public void trocarSenha(@PathVariable long id, @RequestHeader String atual, @RequestHeader("nova") String nova) {
        business.trocarSenha(id, atual, nova);
    }

}