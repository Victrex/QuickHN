/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.repositories;

import hn.unah.grupo5.QuickHN.models.Clientes;
import hn.unah.grupo5.QuickHN.models.Reclamos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Soriano
 */
@Repository
public interface ReclamosRepository extends JpaRepository<Reclamos,String>{
    List<Reclamos> findByidcliente(Clientes idCliente);
}
