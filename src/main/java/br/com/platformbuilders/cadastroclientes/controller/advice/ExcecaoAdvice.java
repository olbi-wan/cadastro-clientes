package br.com.platformbuilders.cadastroclientes.controller.advice;

import static org.springframework.http.ResponseEntity.badRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.platformbuilders.cadastroclientes.exception.CadastroException;

@ControllerAdvice
public class ExcecaoAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CadastroException.class)
	public ResponseEntity<String> cadastro(final CadastroException excecao) {
		return badRequest().body(excecao.getMessage());
	}
	
}