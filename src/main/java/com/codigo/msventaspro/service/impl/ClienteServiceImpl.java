package com.codigo.msventaspro.service.impl;

import com.codigo.msventaspro.aggregates.response.ResponseReniec;
import com.codigo.msventaspro.client.ClientReniec;
import com.codigo.msventaspro.dao.ClienteRepository;
import com.codigo.msventaspro.entities.Cliente;
import com.codigo.msventaspro.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClientReniec clientReniec;

    @Value("${token.api}")
    private String tokenApi;
    @Override
    public Cliente save(Cliente cliente) {
        boolean existe = clienteRepository.existsByNumDoc(cliente.getNumDoc());
        if (existe){
            throw new RuntimeException("Error, la persona ya existe");
        }
        Cliente cliente1 = getClienteReniec(cliente);

        if (cliente1 != null){
            return clienteRepository.save(cliente1);
        }else {
            throw new RuntimeException("Error, la persona No existe en Reniec");
        }

    }

    private Cliente getClienteReniec(Cliente cliente) {
        ResponseReniec responseReniec = getExecutionReniec(cliente.getNumDoc());
        Cliente clienteReniec = new Cliente();

        if(responseReniec != null){
            clienteReniec.setNombres(responseReniec.getNombres());
            clienteReniec.setApellidos(responseReniec.getApellidoPaterno() + " " + responseReniec.getApellidoMaterno());
            clienteReniec.setEmail(cliente.getEmail());
            clienteReniec.setTelefono(cliente.getTelefono());
            clienteReniec.setDireccion(cliente.getDireccion());
            clienteReniec.setTipoDoc(responseReniec.getTipoDocumento());
            clienteReniec.setNumDoc(responseReniec.getNumeroDocumento());
            return clienteReniec;
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Cliente existingCliente = findById(id);
        existingCliente.setNombres(cliente.getNombres());
        existingCliente.setApellidos(cliente.getApellidos());
        existingCliente.setEmail(cliente.getEmail());
        existingCliente.setTelefono(cliente.getTelefono());
        existingCliente.setDireccion(cliente.getDireccion());
        existingCliente.setTipoDoc(cliente.getTipoDoc());
        existingCliente.setNumDoc(cliente.getNumDoc());
        return clienteRepository.save(existingCliente);
    }
    private ResponseReniec getExecutionReniec(String dni){
        String auth = "Bearer "+tokenApi;
        ResponseReniec reniec = clientReniec.getInfoReniec(dni,auth);
        return reniec;
    }
}
