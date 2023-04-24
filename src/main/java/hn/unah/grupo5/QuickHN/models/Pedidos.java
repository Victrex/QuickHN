/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "Pedidos")
public class Pedidos implements Serializable {

    @Id
    @Column(name = "idpedido")
    private String idpedido;
    private Date fechapedido;
    private float subtotal;
    private float total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idisv", referencedColumnName = "idisv")
    @JsonIncludeProperties("isv")
    private Isv idisv;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @JsonIncludeProperties("idusuario")
    private Usuarios idusuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddireccionentrega", referencedColumnName = "iddireccion")
    @JsonIncludeProperties("iddireccion")
    private Direcciones iddireccionentrega;

    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedidosmetodospago",/* ---CREAR ESTA TABLA EN LA BASE DE DATOS--- */
            joinColumns = @JoinColumn(name = "idpedido"),
            inverseJoinColumns = @JoinColumn(name = "idmetodopago"))
    @JsonIncludeProperties("idmetodopago")
    private List<MetodosPago> idmetodopago;

    @OneToMany(mappedBy = "idpedido")
    @JsonIncludeProperties("iddetallepedido")
    private List<DetallesPedido> iddetallepedido;

    @OneToOne(mappedBy = "idpedido")
    @JsonIncludeProperties("idcomprobante")
    private ComprobantesPago idcomprobante;
}
