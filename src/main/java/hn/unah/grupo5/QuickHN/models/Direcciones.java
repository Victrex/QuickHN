/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "Direcciones")
public class Direcciones implements Serializable {

    @Id
    @Column(name = "iddireccion")
    private String iddireccion;

    private String calle;
    private String referencia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddepartamento", referencedColumnName = "iddepartamento")
    @JsonIncludeProperties("iddepartamento")
    private Departamentos iddepartamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @JsonIncludeProperties("idmunicipio")
    private Municipios idmunicipio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcolonia", referencedColumnName = "idcolonia")
    @JsonIncludeProperties("idcolonia")
    private Colonias idcolonia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @JsonIncludeProperties("idpersona")
    private Personas idpersona;

    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
//    @OneToOne(mappedBy="iddireccion")
//    @JsonIncludeProperties("idproveedor")
//    private Proveedores idproveedor;
    @OneToOne(mappedBy = "iddireccionentrega")
    @JsonIncludeProperties("idpedido")
    private Pedidos idpedido;

}
