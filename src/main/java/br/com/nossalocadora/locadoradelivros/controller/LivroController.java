package br.com.nossalocadora.locadoradelivros.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import br.com.nossalocadora.locadoradelivros.model.Livro;
import br.com.nossalocadora.locadoradelivros.service.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listar() {
        return livroService.listarTodos();
    }

    @PostMapping
    public Livro criarLivro(@RequestBody @Valid Livro livro) {
        return livroService.salvar(livro);
    }

    @PostMapping("/{idLivro}/autores/{idAutor}")
    public Livro adicionarAutorAoLivro(@PathVariable Long idLivro, @PathVariable Long idAutor) {
    return livroService.adicionarAutorAoLivro(idLivro, idAutor);
    }


    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody @Valid Livro livro) {
        return livroService.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        livroService.deletar(id);
    }
}
