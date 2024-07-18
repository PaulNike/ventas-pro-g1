package com.codigo.msventaspro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codigo.msventaspro.entities.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, Long>{
    
}
