package br.com.platformbuilders.cadastroclientes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * AllArgsConstructor - deve ser somente utilizado nos testes unitarios.
 * NoArgsConstructor  - deve ser somente utilizado pelo FasterXML/jackson.
 */
@AllArgsConstructor(onConstructor_ = @Deprecated)
@NoArgsConstructor(onConstructor_  = @Deprecated)
@Getter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    @Setter
    private String senha;

    /**
     * <p>Valida a senha do usuario.</p>
     * <i>https://martinfowler.com/bliki/TellDontAsk.html</i>
     * @param atual senha do {@link Usuario}
     * @return {@code true} se a {@code senha} for valida
     */
    public boolean isValida(final String senha) {
        return this.senha.equals(senha);
    }

}