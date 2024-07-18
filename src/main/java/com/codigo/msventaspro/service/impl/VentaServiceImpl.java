package com.codigo.msventaspro.service.impl;

import com.codigo.msventaspro.aggregates.constants.Constants;
import com.codigo.msventaspro.dao.CalzadoRepository;
import com.codigo.msventaspro.dao.VentaRepository;
import com.codigo.msventaspro.entities.Calzado;
import com.codigo.msventaspro.entities.DetalleVenta;
import com.codigo.msventaspro.entities.Venta;
import com.codigo.msventaspro.service.VentaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    private final CalzadoRepository calzadoRepository;

    @Transactional
    @Override
    public Venta save(Venta venta) {
        venta.setDevolucion(false);
        venta.setEstado(Constants.ESTADO_PAGADO);
        Venta nuevaVenta = ventaRepository.save(venta);

        // Actualizar el stock de cada calzado en la venta y asociar los detalles con la venta
        for (DetalleVenta detalle : venta.getDetalles()) {
            // Obtener el calzado desde el repositorio para obtener el stock real
            Calzado calzado = calzadoRepository.findById(detalle.getCalzado().getId())
                    .orElseThrow(() -> new NoSuchElementException("Calzado no encontrado"));

            int nuevaCantidad = calzado.getStock() - detalle.getCantidad();
            if (nuevaCantidad < 0) {
                throw new IllegalArgumentException("No hay suficiente stock para el calzado: " + calzado.getNombre());
            }

            // Actualizar el stock y guardar el calzado actualizado
            calzado.setStock(nuevaCantidad);
            calzadoRepository.save(calzado);

            // Asociar el detalle con la venta
            detalle.setVenta(nuevaVenta);
        }

        // Guardar los detalles de la venta
        nuevaVenta.setDetalles(venta.getDetalles());
        nuevaVenta = ventaRepository.save(nuevaVenta);

        return nuevaVenta;
    }

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Venta no encontrada"));
    }

    @Override
    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }
}
