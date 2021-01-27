package com.nascimeto.bookstore.service;

import com.nascimeto.bookstore.domain.Categoria;
import com.nascimeto.bookstore.domain.Livro;
import com.nascimeto.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nascimeto.bookstore.service.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Long idLivro) {
        Optional<Livro> livro = livroRepository.findById(idLivro);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + idLivro + ", Tipo: " + Livro.class.getName()));
    }



}
