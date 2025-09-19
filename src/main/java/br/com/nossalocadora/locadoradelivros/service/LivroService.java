package br.com.nossalocadora.locadoradelivros.service;

import org.springframework.stereotype.Service;
import java.util.List;
import br.com.nossalocadora.locadoradelivros.model.Livro;
import br.com.nossalocadora.locadoradelivros.repository.LivroRepository;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    public Livro atualizar(Long id, Livro dados) {
        Livro livro = repository.findById(id).orElseThrow();
        livro.setTitulo(dados.getTitulo());
        livro.setClassificacao(dados.getClassificacao());
        livro.setQuantidadeExemplares(dados.getQuantidadeExemplares());
        return repository.save(livro);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
