/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kenne
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ComprobantesPago")
public class ComprobantesPago implements Serializable{
    @Id
    private String idcomprobantepago;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idpedido", referencedColumnName="idpedido")
    @JsonIgnoreProperties("idcomprobantepago")
    private Pedidos idpedido;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="ComprobantesPago_MetodosPago",/* ---CREAR ESTA TABLA EN LA BASE DE DATOS--- */
            joinColumns=@JoinColumn(name="idcomprobantepago"),
            inverseJoinColumns=@JoinColumn(name="idmetodopago"))
    @JsonIgnoreProperties("idcomprobantepago")
    private List<MetodosPago> idmetodopago;    
}
