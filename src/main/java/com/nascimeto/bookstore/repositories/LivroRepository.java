package com.nascimeto.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nascimeto.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
