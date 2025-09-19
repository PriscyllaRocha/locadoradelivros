package br.com.nossalocadora.locadoradelivros.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "autores")
    private Set<Livro> livros; // relação inversa com Livro
}
