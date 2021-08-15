package br.com.platformbuilders.cadastroclientes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>Representa o endereco principal ou de entrega do cliente.</p>
 *
 * @see Cliente
 */
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // As mensagens deveriam estar centralizadas em um arquivo de propriedades, mas por questao de simplicidade foram declaradas aqui.
    @NotBlank(message = "O estado do endereço é obrigatório.")
    private String estado;

    @NotBlank(message = "O logradouro do endereço é obrigatório.")
    private String logradouro;

    @NotBlank(message = "O número do endereço é obrigatório.")
    private String numero;


    /** Se {@code true} representa o endereco "atual" de "entrega". */
    @Setter
    private boolean entrega;

}