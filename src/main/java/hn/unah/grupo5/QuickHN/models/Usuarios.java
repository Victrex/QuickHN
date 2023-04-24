/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name="Usuarios")
public class Usuarios implements Serializable{
    @Id
    private String idusuario;    
    private String nombreusuario;
    private String correoelectronico;
    private String contrasenia;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idimagen",referencedColumnName="idimagen")
    @JsonIncludeProperties("ruta")
    private Imagenes idimagen;    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idtipousuario", referencedColumnName="idtipousuario")
    @JsonIncludeProperties({"idtipousuario","descripcion"})
    private TiposUsuario idtipousuario;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToOne(mappedBy="idusuario")
    @JsonIncludeProperties("idproveedor")
    private Proveedores idproveedor;
    
    @OneToOne(mappedBy="idusuario")
    @JsonIncludeProperties("idcliente")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Clientes idcliente;
    
    @OneToMany(mappedBy="idusuario")
    @JsonIncludeProperties({"calificacion","idproducto"})
    private List<Calificaciones> idcalificacion;
}
