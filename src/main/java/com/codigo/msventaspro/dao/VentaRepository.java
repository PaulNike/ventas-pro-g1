package com.codigo.msventaspro.dao;

import com.codigo.msventaspro.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
