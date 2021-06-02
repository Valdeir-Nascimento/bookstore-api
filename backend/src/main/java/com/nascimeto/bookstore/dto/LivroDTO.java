package com.nascimeto.bookstore.dto;

import com.nascimeto.bookstore.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;

    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
