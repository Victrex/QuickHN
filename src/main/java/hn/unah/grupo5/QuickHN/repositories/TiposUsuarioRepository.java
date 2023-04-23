/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.repositories;

import hn.unah.grupo5.QuickHN.models.TiposUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenne
 */
@Repository
public interface TiposUsuarioRepository extends JpaRepository<TiposUsuario, String>{
    
}
