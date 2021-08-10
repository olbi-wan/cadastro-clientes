package br.com.platformbuilders.cadastroclientes.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.platformbuilders.cadastroclientes.exception.CadastroException;
import br.com.platformbuilders.cadastroclientes.model.Usuario;
import br.com.platformbuilders.cadastroclientes.repository.UsuarioRepository;

/*
 * Testes com Mockito...
 */
@SuppressWarnings("deprecation")
@ExtendWith(MockitoExtension.class)
public class UsuarioBusinessTest {

    @Mock private UsuarioRepository repository;
    @InjectMocks private UsuarioBusiness usuarioBusiness;

    @Test
    public void dadoCadastrar_quandoUsuarioDuplicado_entaoLancaCadastroException() {

        when(repository.findByEmail(any())).thenReturn(Optional.of(new Usuario()));

        final var excecao = assertThrows(CadastroException.class, () -> usuarioBusiness.cadastrar(new Usuario()));

        assertEquals("Usuário duplicado.", excecao.getMessage());

    }

    @Test
    public void dadoCadastrar_quandoUsuarioNovo_entaoSalvaUsuario() {

        final var usuario = new Usuario();

        usuarioBusiness.cadastrar(usuario);

        verify(repository, atLeastOnce()).save(eq(usuario));

    }

}