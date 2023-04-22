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
@Table(name="Productos")
public class Productos implements Serializable{
    @Id
    private String idproducto;
    private String nombreproducto;
    private String descripcion;
    private float precio;
    private int stockdisponible;
    private float pesoproducto; 
    private String modeloproducto;
    private String marcaproducto;
    private int cantdiasgarantia;
    
    //pendiente de relacion
    private Proveedores idproveedor;
    
    //pendiente de relacion
    private CategoriasProducto idcategoriaproducto;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idimagen",referencedColumnName="idimagen")
    @JsonIgnoreProperties("idproducto")
    private Imagenes idimagen;
    
    //pendiente de relacion
    private Dimensiones iddimension;
    
    //pendiente de relacion
    private Colores idcolor;
    
}
