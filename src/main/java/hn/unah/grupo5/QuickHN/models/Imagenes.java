/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="Imagenes")
public class Imagenes implements Serializable{
    @Id
    private String  idimagen;    
    private float tamanio;
    private String ruta;
    private String descripcion;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToOne(mappedBy="idimagen")
    @JsonIgnoreProperties("idimagen")
    private SolicitudesSAR idsolicitudsar;
    
//    @OneToOne(mappedBy="idimagen")
//    @JsonIgnoreProperties("idimagen")
//    private CategoriasProducto idcategoriaproducto;
//
//    @OneToOne(mappedBy="idimagen")
//    @JsonIgnoreProperties("idimagen")
//    private Empleados idempleado;
//    
//    @OneToOne(mappedBy="idimagen")
//    @JsonIgnoreProperties("idimagen")
//    private Usuarios idusuario;
//    
//    @OneToOne(mappedBy="idimagen")
//    @JsonIgnoreProperties("idimagen")
//    private Productos idproducto;    
}
