/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.TiposUsuario;
import hn.unah.grupo5.QuickHN.models.Usuarios;
import hn.unah.grupo5.QuickHN.repositories.UsuariosRepository;
import hn.unah.grupo5.QuickHN.services.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class UsuariosServicesImpl implements UsuariosService{
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return this.usuariosRepository.findAll();
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuario) {
        return this.usuariosRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String idUsuario) {
        this.usuariosRepository.deleteById(idUsuario);
    }

    @Override
    public Usuarios getUsuarioByID(String idUsuario) {
        return this.usuariosRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public List<Usuarios> getUsuariosByTipo(TiposUsuario idTipoUsuario) {
        return this.usuariosRepository.findByidtipousuario(idTipoUsuario);
    }

    @Override
    public Usuarios getUsuarioByCorreoElectronico(String correoelectronico) {
        return this.usuariosRepository.findBycorreoelectronico(correoelectronico);
    }
    
}
