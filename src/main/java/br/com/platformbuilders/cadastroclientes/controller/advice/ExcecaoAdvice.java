package br.com.platformbuilders.cadastroclientes.controller.advice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.platformbuilders.cadastroclientes.exception.CadastroException;

/**
 * <p>Captura as excecoes e envia uma mensagem informativa.</p>
 * <i>Para manter a simplicidade optei por retornar uma "mensagem" ao invés de um "JSON".</i>
 */
@ControllerAdvice
@RestController
@ResponseStatus(BAD_REQUEST)
public class ExcecaoAdvice {

    // NOTA: Os metodos abaixo, seguem o padrao do nome da classe da excecao capturada sem o sufixo "Exception":

    /**
     * <p>Excecoes conhecidas dentro da regra de negocio.</p>
     * @param excecao {@link CadastroException}
     * @return mensagem informativa
     */
    @ExceptionHandler(CadastroException.class)
    public String cadastro(final CadastroException excecao) {
        return excecao.getMessage();
    }

    /**
     * <p>Excecoes lancadas pelo "Bean Validation".</p>
     * @param excecao {@link MethodArgumentNotValidException}
     * @return "filtra o primeiro erro" e retorna uma mensagem informativa
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValid(MethodArgumentNotValidException excecao) {
        return excecao.getBindingResult().getFieldError().getDefaultMessage();
    }

}