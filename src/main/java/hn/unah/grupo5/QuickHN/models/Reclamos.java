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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
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
@Table(name="Reclamos")
public class Reclamos implements Serializable{    
    @Id
    private String idreclamo;    
    private String descripcion;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idcliente", referencedColumnName="idcliente")
    @JsonIgnoreProperties("idreclamo")
    private Clientes idcliente;    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddetallepedido", referencedColumnName="iddetallepedido")
    @JsonIgnoreProperties("idreclamo")
    private DetallesPedido iddetallepedido;    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idmotivoreclamo", referencedColumnName="idmotivoreclamo")
    @JsonIgnoreProperties("idreclamo")
    private MotivoReclamos idmotivoreclamo;    
    
}
