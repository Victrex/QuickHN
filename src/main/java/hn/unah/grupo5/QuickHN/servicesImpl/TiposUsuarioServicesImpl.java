/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.TiposUsuario;
import hn.unah.grupo5.QuickHN.repositories.TiposUsuarioRepository;
import hn.unah.grupo5.QuickHN.services.TiposUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kenne
 */
@Service
public class TiposUsuarioServicesImpl implements TiposUsuarioService{
    @Autowired
    private TiposUsuarioRepository tiposUsuarioRepository;
    
    @Override
    public List<TiposUsuario> getAllTiposUsuario(){
        return this.tiposUsuarioRepository.findAll();
    }
    
    @Override
    public TiposUsuario getTipoUsuarioByID(String idTipoUsuario){
        return this.tiposUsuarioRepository.findById(idTipoUsuario).orElse(null);
    }
    
}
