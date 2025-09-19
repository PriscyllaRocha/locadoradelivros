package br.com.nossalocadora.locadoradelivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.nossalocadora.locadoradelivros.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
