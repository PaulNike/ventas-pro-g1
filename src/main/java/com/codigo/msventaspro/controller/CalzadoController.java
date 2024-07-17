package com.codigo.msventaspro.controller;

import com.codigo.msventaspro.entities.Calzado;
import com.codigo.msventaspro.service.CalzadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/calzado")
@RequiredArgsConstructor
public class CalzadoController {

    private final CalzadoService calzadoService;

    @PostMapping
    public ResponseEntity<Calzado> crearCalzado(@RequestBody Calzado calzado) {
        Calzado nuevoCalzado = calzadoService.save(calzado);
        return new ResponseEntity<>(nuevoCalzado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Calzado> listarCalzados() {
        return calzadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calzado> obtenerCalzado(@PathVariable Long id) {
        Calzado calzado = calzadoService.findById(id);
        return new ResponseEntity<>(calzado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCalzado(@PathVariable Long id) {
        calzadoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calzado> actualizarCalzado(@PathVariable Long id, @RequestBody Calzado calzado) {
        Calzado calzadoActualizado = calzadoService.update(id, calzado);
        return new ResponseEntity<>(calzadoActualizado, HttpStatus.OK);
    }
}
