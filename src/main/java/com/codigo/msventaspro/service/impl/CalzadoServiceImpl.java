package com.codigo.msventaspro.service.impl;

import com.codigo.msventaspro.dao.CalzadoRepository;
import com.codigo.msventaspro.entities.Calzado;
import com.codigo.msventaspro.service.CalzadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CalzadoServiceImpl implements CalzadoService {

    private final CalzadoRepository calzadoRepository;
    @Override
    public Calzado save(Calzado calzado) {
        return calzadoRepository.save(calzado);
    }

    @Override
    public List<Calzado> findAll() {
        return calzadoRepository.findAll();
    }

    @Override
    public Calzado findById(Long id) {
        return calzadoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Calzado no encontrado"));
    }

    @Override
    public void deleteById(Long id) {
        calzadoRepository.deleteById(id);
    }

    @Override
    public Calzado update(Long id, Calzado calzado) {
        Calzado existingCalzado = findById(id);
        existingCalzado.setNombre(calzado.getNombre());
        existingCalzado.setTalla(calzado.getTalla());
        existingCalzado.setValorUnitario(calzado.getValorUnitario());
        existingCalzado.setPrecioUnitario(calzado.getPrecioUnitario());
        existingCalzado.setStock(calzado.getStock());
        existingCalzado.setCategoria(calzado.getCategoria());
        return calzadoRepository.save(existingCalzado);
    }
}
