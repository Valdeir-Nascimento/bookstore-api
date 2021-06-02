package com.nascimeto.bookstore.service;

import com.nascimeto.bookstore.domain.Categoria;
import com.nascimeto.bookstore.domain.Livro;
import com.nascimeto.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nascimeto.bookstore.service.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Long idLivro) {
        Optional<Livro> livro = livroRepository.findById(idLivro);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + idLivro + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Long idCategoria) {
        categoriaService.findById(idCategoria);
        return livroRepository.findByCategoria(idCategoria);
    }

    public Livro update(Long idLivro, Livro livro) {
        Livro novoLivro = findById(idLivro);
        updateData(novoLivro, livro);
        return livroRepository.save(novoLivro);
    }

    private void updateData(Livro novoLivro, Livro livro) {
        novoLivro.setTitulo(livro.getTitulo());
        novoLivro.setAutor(livro.getAutor());
        novoLivro.setTexto(livro.getTexto());
    }

    public Livro create(Long idCategoria, Livro livro) {
        Categoria categoria = categoriaService.findById(idCategoria);
        livro.setId(null);
        livro.setCategoria(categoria);
        return livroRepository.save(livro);
    }

    public void delete(Long idLivro) {
        livroRepository.deleteById(idLivro);
    }
}
