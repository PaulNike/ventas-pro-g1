package com.codigo.msventaspro.service;

import com.codigo.msventaspro.entities.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    List<Categoria> findAll();
    Categoria findById(Long id);
    void deleteById(Long id);
    Categoria update(Long id, Categoria categoria);
}
