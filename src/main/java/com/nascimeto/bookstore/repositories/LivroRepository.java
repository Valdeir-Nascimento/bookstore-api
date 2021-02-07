package com.nascimeto.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nascimeto.bookstore.domain.Livro;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select l from Livro l where l.categoria.id = :idCategoria order by titulo")
    List<Livro> findByCategoria(@Param(value = "idCategoria") Long idCategoria);
}
