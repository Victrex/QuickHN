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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Soriano
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Direcciones")
public class Direcciones implements Serializable{
    @Id
    private String iddireccion;    
    private String calle; 
    private String referencia;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="iddepartamento", referencedColumnName="iddepartamento")
    @JsonIgnoreProperties("iddireccion")
    private Departamentos iddepartamento;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idmunicipio", referencedColumnName="idmunicipio")
    @JsonIgnoreProperties("iddireccion")
    private Municipios idmunicipio;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idcolonia", referencedColumnName="idcolonia")
    @JsonIgnoreProperties("iddireccion")
    private Colonias idcolonia;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToOne(mappedBy="iddireccion")
    @JsonIgnoreProperties("iddireccion")
    private Proveedores idproveedor;
    
    @OneToOne(mappedBy="iddireccionentrega")
    @JsonIgnoreProperties("iddireccion")
    private Pedidos idpedido;
    
//    @ManyToOne(cascade=CascadeType.ALL) 
//    @JoinColumn(name="idpersona", referencedColumnName="idpersona")
//    @JsonIgnoreProperties("iddireccion")
//    private Personas idpersona;
    
}
