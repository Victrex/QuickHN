/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
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
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="ComprobantesPago_MetodosPago",/* ---CREAR ESTA TABLA EN LA BASE DE DATOS--- */
            joinColumns=@JoinColumn(name="idmetodopago"),
            inverseJoinColumns=@JoinColumn(name="idcomprobantepago"))
    @JsonIgnoreProperties("idmetodopago")
    private List<ComprobantesPago> idcomprobantepago;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Pedidos_MetodosPago",/* ---CREAR ESTA TABLA EN LA BASE DE DATOS--- */
            joinColumns=@JoinColumn(name="idmetodopago"),
            inverseJoinColumns=@JoinColumn(name="idpedido"))
    @JsonIgnoreProperties("idmetodopago")
    private List<Pedidos> idpedido;
    
}
