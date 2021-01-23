package com.nascimeto.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nascimeto.bookstore.domain.Categoria;
import com.nascimeto.bookstore.domain.Livro;
import com.nascimeto.bookstore.repositories.CategoriaRepository;
import com.nascimeto.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática", "Livros de TI");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", c1);
		c1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(c1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
		
	}

}
