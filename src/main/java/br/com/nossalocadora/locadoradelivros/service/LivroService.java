package br.com.nossalocadora.locadoradelivros.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.nossalocadora.locadoradelivros.model.Autor;
import br.com.nossalocadora.locadoradelivros.model.Livro;
import br.com.nossalocadora.locadoradelivros.repository.AutorRepository;
import br.com.nossalocadora.locadoradelivros.repository.LivroRepository;
import java.util.HashSet;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    // Lista todos os livros
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    // Salva um novo livro
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    // Atualiza um livro existente
    public Livro atualizar(Long id, Livro livroAtualizado) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID " + id));

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setClassificacao(livroAtualizado.getClassificacao());
        livro.setQuantidadeExemplares(livroAtualizado.getQuantidadeExemplares());
        livro.setAutores(livroAtualizado.getAutores());

        return livroRepository.save(livro);
    }

    // Deleta um livro pelo ID
    public void deletar(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado com ID " + id);
        }
        livroRepository.deleteById(id);
    }

    // Adiciona um autor a um livro existente
    @Transactional
    public Livro adicionarAutorAoLivro(Long idLivro, Long idAutor) {
        System.out.println("🔎 Iniciando associação: Livro=" + idLivro + " Autor=" + idAutor);

        Livro livro = livroRepository.findById(idLivro)
            .orElseThrow(() -> new RuntimeException("❌ Livro não encontrado com ID " + idLivro));
            System.out.println("✅ Livro encontrado: " + livro.getTitulo());

        Autor autor = autorRepository.findById(idAutor)
            .orElseThrow(() -> new RuntimeException("❌ Autor não encontrado com ID " + idAutor));
            System.out.println("✅ Autor encontrado: " + autor.getNome());

        if (livro.getAutores() == null) {
            livro.setAutores(new HashSet<>());
        }
        livro.getAutores().add(autor);

        if (autor.getLivros() == null) {
            autor.setLivros(new HashSet<>());
        }
        autor.getLivros().add(livro);

        System.out.println("💾 Salvando relacionamento...");
        Livro salvo = livroRepository.save(livro);
        System.out.println("✅ Relacionamento salvo com sucesso!");

        return salvo;
    }
}
