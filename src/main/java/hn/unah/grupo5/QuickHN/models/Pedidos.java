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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
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
    private String idpedido; //Identificar Relación
    private Date fechapedido;
    private float subtotal;
    private float isv;
    private float total;

    //Identificar Relación
    private Usuarios idusuario;

    //Identificar Relación
    private MetodosPago idmetodopago;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddireccionentrega",referencedColumnName="iddireccion")
    @JsonIgnoreProperties("idpedido")
    private Direcciones iddireccionentrega;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)

}
