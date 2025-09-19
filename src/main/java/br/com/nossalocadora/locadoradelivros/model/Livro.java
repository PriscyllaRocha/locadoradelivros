package br.com.nossalocadora.locadoradelivros.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String classificacao; // Diamante, Ouro, Prata e Bronze
    private Integer quantidadeExemplares;
}
