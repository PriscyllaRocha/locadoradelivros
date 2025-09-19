package br.com.nossalocadora.locadoradelivros.repository;

import br.com.nossalocadora.locadoradelivros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {}
