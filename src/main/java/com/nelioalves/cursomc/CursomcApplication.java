package com.nelioalves.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
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
	private EstadoRepository estadoRepository;
	private CidadeRepository cidadeRepository;

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


		Estado est1 = new Estado(null, "Minas Gerais", new ArrayList<Cidade>());
		Estado est2 = new Estado(null, "São Paulo", new ArrayList<Cidade>());
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
}