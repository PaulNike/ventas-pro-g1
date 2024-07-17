package com.codigo.msventaspro.service;

import com.codigo.msventaspro.entities.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findById(Long id);
    void deleteById(Long id);
    Cliente update(Long id, Cliente cliente);
}
