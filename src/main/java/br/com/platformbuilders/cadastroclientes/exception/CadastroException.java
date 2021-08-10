package br.com.platformbuilders.cadastroclientes.exception;

/**
 * <p>Excecao generica.</p>
 */
@SuppressWarnings("serial")
public class CadastroException extends RuntimeException {

    public CadastroException(String mensagem) {
        super(mensagem);
    }

}