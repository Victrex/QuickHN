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
@Table(name="DetallesPedido")
public class DetallesPedido implements Serializable{
    @Id
    private String iddetallepedido;
    private int cantidad;
    private float preciounitario;
    private float total;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idproducto", referencedColumnName="idproducto")
    @JsonIgnoreProperties("iddetallepedido")
    private Productos idproducto;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idpedido", referencedColumnName="idpedido")
    @JsonIgnoreProperties("iddetallepedido")
    private Pedidos idpedido;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idproveedor", referencedColumnName="idproveedor")
    @JsonIgnoreProperties("iddetallepedido")
    private Proveedores idproveedor;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idestadopedido", referencedColumnName="idestadopedido")
    @JsonIgnoreProperties("iddetallepedido")
    private EstadosPedido idestadopedido; 
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="iddetallepedido")
    @JsonIgnoreProperties("iddetallepedido")
    private List<Reclamos> idreclamo;
    
    @OneToOne(mappedBy="iddetallepedido")
    @JsonIgnoreProperties("iddetallepedido")
    private DetallesFactura iddetallefactura;
}
