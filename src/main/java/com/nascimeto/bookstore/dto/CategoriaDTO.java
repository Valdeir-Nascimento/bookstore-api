package com.nascimeto.bookstore.dto;

import java.io.Serializable;

import com.nascimeto.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 2 e 100 caracteres")
    @NotBlank(message = "Campo NOME é requerido")
    private String nome;
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 2 e 100 caracteres")
    @NotBlank(message = "Campo DESCRIÇÃO é requerido")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
