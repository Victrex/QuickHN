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
@Table(name="Proveedores")
public class Proveedores implements Serializable{
    @Id
    private String idproveedor;
    private String rtn;
    private String nombreproveedor;
    private String correoelectronico;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idusuario", referencedColumnName="idusuario")
    @JsonIgnoreProperties("idproveedor")
    private Usuarios idusuario;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddireccion", referencedColumnName="iddireccion")
    @JsonIgnoreProperties("idproveedor")
    private Direcciones iddireccion;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idestadoproveedor", referencedColumnName="idestadoproveedor")
    @JsonIgnoreProperties("idproveedor")
    private EstadosProveedor idestadoproveedor;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    //pendiente de relacion
    private Productos idproducto;
    
    //pendiente de relacion
    private HistorialCompras idhistorial;
    
    //pendiente de relacion
    private DetallesPedido iddetallepedido;
    
    //pendiente de relacion
    private Facturas idfactura;
}
