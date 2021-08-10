package br.com.platformbuilders.cadastroclientes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    private String estado;

    private String logradouro;

    private String numero;


    /** Se {@code true} representa o endereco "atual" de "entrega". */
    @Setter
    private boolean entrega;

}