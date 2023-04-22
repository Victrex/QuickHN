/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author mcenteno
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="MetodosPago")
public class MetodosPago implements Serializable {
    @Id
    private String idmetodopago;
    private String tipometodo;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    //pendiente de relacion
    private ComprobantesPago idcomprobantepago;
    
    //pendiente de relacion
    private Pedidos idpedido;
    
}
