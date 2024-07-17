package com.codigo.msventaspro.dao;

import com.codigo.msventaspro.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
