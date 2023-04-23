/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.repositories;

import hn.unah.grupo5.QuickHN.models.CategoriasProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Soriano
 */
@Repository
public interface CategoriasProductoRepository extends JpaRepository<CategoriasProducto,String>{
    
}
