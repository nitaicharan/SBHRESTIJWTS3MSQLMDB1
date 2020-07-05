package com.nelioalves.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	private CategoriaRepository categoriaRepository;
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", new ArrayList<Produto>());
		Categoria cat2 = new Categoria(null, "Escritório", new ArrayList<Produto>());

		Produto p1 = new Produto(null, "Computador", 2000.00, new ArrayList<Categoria>());
		Produto p2 = new Produto(null, "Impressora", 800.00, new ArrayList<Categoria>());
		Produto p3 = new Produto(null, "Mouse", 80.00, new ArrayList<Categoria>());

		cat1.setProdutos(Arrays.asList(p1, p2, p3));
		cat2.setProdutos(Arrays.asList(p2));;
		
		p1.setCategorias(Arrays.asList(cat1));;
		p2.setCategorias(Arrays.asList(cat1, cat2));;
		p3.setCategorias(Arrays.asList(cat1));;

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}