package br.com.platformbuilders.cadastroclientes.model;

import static java.util.Collections.unmodifiableCollection;
import static java.util.Comparator.comparingLong;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * AllArgsConstructor - deve ser somente utilizado nos testes unitarios.
 * NoArgsConstructor  - deve ser somente utilizado pelo FasterXML/jackson.
 */

/**
 * <p>Representa um cliente e seus enderecos: principal ou de entrega (nesse caso podendo ser varios).</p>
 *
 * @see Usuario
 */
@AllArgsConstructor(onConstructor_ = @Deprecated)
@NoArgsConstructor(onConstructor_  = @Deprecated)
@Getter
@ToString
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {

    @Id
    private Long id;

    // As mensagens deveriam estar centralizadas em um arquivo de propriedades, mas por questao de simplicidade foram declaradas aqui.
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de nascimento é obritatória.")
    private LocalDate nascimento;

    @NotEmpty(message = "Pelo menos um endereço deve ser informado.")
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<@Valid Endereco> enderecos;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Usuario usuario;

    /**
     * <p>Atualiza o {@link Endereco} de entrega do {@link Cliente}.</p>
     * <i>https://martinfowler.com/bliki/TellDontAsk.html</i>
     * @param entrega novo {@link Endereco} de entrega
     */
    public void addEnderecoEntrega(Endereco entrega) {

        // Desabilita o antigo endereco de entrega.
        getEnderecoEntrega().ifPresent(endereco -> endereco.setEntrega(false));

        // Adiciona/Atualiza o novo endereco de entrega.
        enderecos.add(entrega.setEntrega(true));

    }

    /**
     * <p>Recupera o {@link Endereco} do {@link Cliente} utilizado na entrega.</p>
     * <i>https://martinfowler.com/bliki/TellDontAsk.html</i>
     * @return {@link Endereco} de entrega
     */
    @JsonProperty("endereco_entrega")
    public Optional<Endereco> getEnderecoEntrega() {
        return enderecos.stream().filter(Endereco::isEntrega).findFirst();
    }

    /**
     * <p>Recupera o {@link Endereco} principal do {@link Cliente}.</p>
     * <i>https://martinfowler.com/bliki/TellDontAsk.html</i>
     * @return {@link Endereco} principal
     */
    @JsonProperty("endereco_principal")
    public Optional<Endereco> getEnderecoPrincipal() {
        return enderecos.stream().min(comparingLong(Endereco::getId));
    }

    /**
     * <p>Recupera os {@link Endereco}s do {@link Cliente}.</p>
     * <i>Java Efetivo (Joshua Bloch) - atributos imutaveis</i>
     * @return lista de {@link Endereco}s
     */
    public Collection<Endereco> getEnderecos() {
        return unmodifiableCollection(enderecos);
    }

    public void setUsuario(Usuario usuario) {
    	this.id = (this.usuario = usuario).getId();
    }

}