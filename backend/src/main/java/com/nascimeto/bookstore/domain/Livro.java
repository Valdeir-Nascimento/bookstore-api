package com.nascimeto.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

@Entity
public class Livro implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 50 caracteres")
    @NotBlank(message = "Campo TITULO é requerido")
    private String titulo;
    @Length(min = 3, max = 50, message = "O campo nome do AUTOR deve ter entre 3 e 50 caracteres")
    @NotBlank(message = "Campo nome do AUTOR  é requerido")
    private String autor;
    @Length(min = 3, max = 500, message = "O campo TEXTO deve ter entre 10 e 500 caracteres")
    @NotBlank(message = "Campo TEXTO  é requerido")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Long id, String titulo, String autor, String texto, Categoria categoria) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.categoria = categoria;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + "]";
    }

}
