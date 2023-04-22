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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
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
@Table(name="Pedidos")
public class Pedidos implements Serializable {
    @Id
    private String idpedido;
    private Date fechapedido;
    private float subtotal;
    private float isv;
    private float total;

    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idusuario", referencedColumnName="idusuario")
    @JsonIgnoreProperties("idpedido")
    private Usuarios idusuario;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Pedidos_MetodosPago",/* ---CREAR ESTA TABLA EN LA BASE DE DATOS--- */
            joinColumns=@JoinColumn(name="idpedido"),
            inverseJoinColumns=@JoinColumn(name="idmetodopago"))
    @JsonIgnoreProperties("idpedido")
    private List<MetodosPago> idmetodopago;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddireccionentrega",referencedColumnName="iddireccion")
    @JsonIgnoreProperties("idpedido")
    private Direcciones iddireccionentrega;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="idpedido")
    @JsonIgnoreProperties("idpedido")
    private List<DetallesPedido> iddetallepedido;
    
    @OneToMany(mappedBy="idpedido")
    @JsonIgnoreProperties("idpedido")
    private List<HistorialCompras> idhistorial;
    
    @OneToOne(mappedBy="idpedido")
    @JsonIgnoreProperties("idpedido")
    private ComprobantesPago idcomprobantepago;
}
