package com.codigo.msventaspro.dao;

import com.codigo.msventaspro.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Boolean existsByNumDoc(String numDoc);
}
