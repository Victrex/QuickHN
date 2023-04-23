/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Usuarios;
import java.util.List;

/**
 *
 * @author Soriano
 */
public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios saveUsuario(Usuarios usuario);
    void deleteUsuario(String idUsuario);
    Usuarios getUsuarioByID(String idUsuario);
    
}
