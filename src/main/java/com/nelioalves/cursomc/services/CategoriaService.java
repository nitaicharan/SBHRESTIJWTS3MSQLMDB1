package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {
    private CategoriaRepository repository;

    public Categoria find(Integer id) {
        return repository.findById(id).orElse(null);
    }
}