/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Clientes;
import hn.unah.grupo5.QuickHN.repositories.ClientesRepository;
import hn.unah.grupo5.QuickHN.services.ClientesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class ClientesServicesImpl implements ClientesService{
    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public List<Clientes> getAllClientes() {
        return this.clientesRepository.findAll();
    }

    @Override
    public Clientes saveCliente(Clientes cliente) {
        return this.clientesRepository.save(cliente);
    }

    @Override
    public void deleteCliente(String idCliente) {
        this.clientesRepository.deleteById(idCliente);
    }

    @Override
    public Clientes getClienteByID(String idCliente) {
        return this.clientesRepository.findById(idCliente).orElse(null);
    }
    
}
