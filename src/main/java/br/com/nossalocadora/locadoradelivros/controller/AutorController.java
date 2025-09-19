package br.com.nossalocadora.locadoradelivros.controller;

import br.com.nossalocadora.locadoradelivros.model.Autor;
import br.com.nossalocadora.locadoradelivros.service.AutorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listar() {
        return autorService.listarTodos();
    }

    @PostMapping
    public Autor criar(@RequestBody Autor autor) {
        return autorService.salvar(autor);
    }

    @GetMapping("/{id}")
    public Autor buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        autorService.deletar(id);
    }
}