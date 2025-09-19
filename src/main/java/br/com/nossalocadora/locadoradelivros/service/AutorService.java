package br.com.nossalocadora.locadoradelivros.service;

import br.com.nossalocadora.locadoradelivros.model.Autor;
import br.com.nossalocadora.locadoradelivros.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}