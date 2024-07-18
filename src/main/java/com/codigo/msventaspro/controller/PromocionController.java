package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.entities.Promocion;
import com.codigo.msventaspro.service.PromocionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/promocion")
@RequiredArgsConstructor
public class PromocionController {

    private final PromocionService promocionService;

    @PostMapping
    public ResponseEntity<Promocion> crearPromocion(@RequestBody Promocion promocion) {
        Promocion nuevaPromocion = promocionService.save(promocion);
        return new ResponseEntity<>(nuevaPromocion, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Promocion> listarPromociones() {
        return promocionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocion> obtenerPromocion(@PathVariable Long id) {
        Promocion promocion = promocionService.findById(id);
        return new ResponseEntity<>(promocion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPromocion(@PathVariable Long id) {
        promocionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocion> actualizarPromocion(@PathVariable Long id, @RequestBody Promocion promocion) {
        Promocion promocionActualizada = promocionService.update(id, promocion);
        return new ResponseEntity<>(promocionActualizada, HttpStatus.OK);
    }
}
