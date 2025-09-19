package br.com.nossalocadora.locadoradelivros.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import br.com.nossalocadora.locadoradelivros.model.Livro;
import br.com.nossalocadora.locadoradelivros.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Livro> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return service.salvar(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        return service.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
