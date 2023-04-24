/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.repositories;

import hn.unah.grupo5.QuickHN.models.TiposUsuario;
import hn.unah.grupo5.QuickHN.models.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Soriano
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,String>{
    List<Usuarios> findByidtipousuario(TiposUsuario idTipoUsuario);
    Usuarios findBycorreoelectronico(String correoelectronico);
}
