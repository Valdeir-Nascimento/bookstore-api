package com.nascimeto.bookstore.controllers;

import com.nascimeto.bookstore.domain.Livro;
import com.nascimeto.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
