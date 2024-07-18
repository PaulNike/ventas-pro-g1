package com.codigo.msventaspro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codigo.msventaspro.dao.PromocionRepository;
import com.codigo.msventaspro.entities.Promocion;
import com.codigo.msventaspro.service.PromocionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromocionServiceImpl implements PromocionService {

    private final PromocionRepository promocionRepository;

    @Override
    public Promocion save(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    @Override
    public List<Promocion> findAll() {
        return promocionRepository.findAll();
    }

    @Override
    public Promocion findById(Long id) {
        return promocionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        promocionRepository.deleteById(id);
    }

    @Override
    public Promocion update(Long id, Promocion promocion) {
        Promocion promocionActual = promocionRepository.findById(id).orElse(null);
        if (promocionActual == null) {
            return null;
        }
        promocionActual.setId(promocion.getId());
        promocionActual.setDescripcion(promocion.getDescripcion());
        promocionActual.setDescuento(promocion.getDescuento());
        return promocionRepository.save(promocionActual);
    }

}
