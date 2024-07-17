package com.codigo.msventaspro.service;

import com.codigo.msventaspro.entities.Venta;

import java.util.List;

public interface VentaService {
    Venta save(Venta venta);
    List<Venta> findAll();
    Venta findById(Long id);
    void deleteById(Long id);
}
