package br.com.nossalocadora.locadoradelivros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{livro.classificacao.obrigatoria}")
    private Classificacao classificacao;

    private Integer quantidadeExemplares;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
        name = "livro_autor",
        joinColumns = @JoinColumn(name = "livro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores; // Adicionado aqui
}
