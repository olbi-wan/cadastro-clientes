package br.com.platformbuilders.cadastroclientes.controller.advice;

import static org.assertj.core.internal.bytebuddy.utility.RandomString.make;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.platformbuilders.cadastroclientes.exception.CadastroException;

/*
 * Testes com Mockito...
 */
@ExtendWith(MockitoExtension.class)
public class ExcecaoAdviceTest {

    @InjectMocks private ExcecaoAdvice excecaoAdvice;

    // Mensagem gerada randomicamente.
    private final String mensagem = make();

    @Test
    public void dadoCadastro_quandoCapturarExcecao_entaoRetornarMensagem() {
        // Realizo o "mock" e simulo o retorno em apenas uma linha.
        assertEquals(mensagem, excecaoAdvice.cadastro(when(mock(CadastroException.class).getMessage()).thenReturn(mensagem).getMock()));
    }

}