package com.codigo.msventaspro.service;

import com.codigo.msventaspro.entities.Calzado;

import java.util.List;

public interface CalzadoService {
    Calzado save(Calzado calzado);
    List<Calzado> findAll();
    Calzado findById(Long id);
    void deleteById(Long id);
    Calzado update(Long id, Calzado calzado);
}
