/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
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
    @JsonIncludeProperties("idusuario")
    private Usuarios idusuario;
    
//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="iddireccion", referencedColumnName="iddireccion")
//    @JsonIncludeProperties("iddireccion")
//    private Direcciones iddireccion;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idestadoproveedor", referencedColumnName="idestadoproveedor")
    @JsonIgnoreProperties("idproveedor")
    private EstadosProveedor idestadoproveedor;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="idproveedor")
    @JsonIgnoreProperties("idproveedor")
    private List<Productos> idproducto;
    
    @OneToMany(mappedBy="idproveedor")
    @JsonIgnoreProperties("idproveedor")
    private List<HistorialCompras> idhistorial;
    
    @OneToMany(mappedBy="idproveedor")
    @JsonIgnoreProperties("idproveedor")
    private List<DetallesPedido> iddetallepedido;
    
    @OneToMany(mappedBy="idproveedor")
    @JsonIgnoreProperties("idproveedor")
    private List<Facturas> idfactura;
}
