package com.nascimeto.bookstore.controller;

import com.nascimeto.bookstore.domain.Livro;
import com.nascimeto.bookstore.dto.LivroDTO;
import com.nascimeto.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{idLivro}")
    public ResponseEntity<Livro> findById(@PathVariable Long idLivro) {
        Livro livro = livroService.findById(idLivro);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long idCategoria) {
        List<Livro> livros = livroService.findAll(idCategoria);
        List<LivroDTO> dtoList = livros.stream().map(LivroDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @PutMapping("/{idLivro}")
    public ResponseEntity<Livro> update(@PathVariable Long idLivro, @RequestBody @Valid Livro livro) {
        Livro livroAtualizado = livroService.update(idLivro, livro);
        return ResponseEntity.ok().body(livroAtualizado);
    }

    @PatchMapping("/{idLivro}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Long idLivro, @RequestBody  @Valid  Livro livro) {
        Livro livroAtualizado = livroService.update(idLivro, livro);
        return ResponseEntity.ok().body(livroAtualizado);
    }

    @PostMapping
    public ResponseEntity<Livro> create(
            @RequestParam(value = "categoria", defaultValue = "0") Long idCategoria, @RequestBody @Valid Livro livro) {
        Livro novoLivro = livroService.create(idCategoria, livro);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/livros/{id}")
                .buildAndExpand(livro.getId())
                .toUri();
        return ResponseEntity.created(uri).body(novoLivro);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idLivro}")
    public void delete(@PathVariable Long idLivro) {
        livroService.delete(idLivro);
    }

}
