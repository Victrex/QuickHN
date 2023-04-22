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
@Table(name="Usuarios")
public class Usuarios implements Serializable{
    @Id
    private String idusuario;    
    private String nombreusuario;
    private String correoelectronico;
    private String contrasenia;
    private String tipousuario;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idimagen",referencedColumnName="idimagen")
    @JsonIgnoreProperties("idusuario")
    private Imagenes idimagen;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToOne(mappedBy="idusuario")
    @JsonIgnoreProperties("idusuario")
    private Proveedores idproveedor;
    
    @OneToMany(mappedBy="idusuario")
    @JsonIgnoreProperties("idusuario")
    private List<Pedidos> idpedido;
    
    @OneToMany(mappedBy="idusuario")
    @JsonIgnoreProperties("idusuario")
    private List<Logs> idlog;
    
    @OneToOne(mappedBy="idusuario")
    @JsonIgnoreProperties("idusuario")
    private Clientes idcliente;
    
    @OneToMany(mappedBy="idusuario")
    @JsonIgnoreProperties("idusuario")
    private List<Calificaciones> idcalificacion;
}
