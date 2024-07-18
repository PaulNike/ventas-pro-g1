package com.codigo.msventaspro.service;

import java.util.List;

import com.codigo.msventaspro.entities.Promocion;

public interface PromocionService {

    Promocion save(Promocion promocion);

    List<Promocion> findAll();

    Promocion findById(Long id);

    void deleteById(Long id);

    Promocion update(Long id, Promocion promocion);
}
