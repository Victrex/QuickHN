/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@IdClass(PedidosMetodosPagoID.class)
@Table(name="pedidosmetodospago")
public class PedidosMetodosPago implements Serializable{
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @JsonIncludeProperties("idpedido")
    private Pedidos idpedido;
    
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idmetodopago", referencedColumnName = "idmetodopago")
    @JsonIncludeProperties("idmetodopago")
    private MetodosPago idmetodopago;
}
