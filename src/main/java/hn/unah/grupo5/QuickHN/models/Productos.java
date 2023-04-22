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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idproveedor", referencedColumnName="idproveedor")
    @JsonIgnoreProperties("idproducto")
    private Proveedores idproveedor;
    
    //pendiente de relacion
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Productos_CategoriasProducto",/* ---CREAR ESTA TABLA EN LA BASE DE DATOS--- */
            joinColumns=@JoinColumn(name="idproducto"),
            inverseJoinColumns=@JoinColumn(name="idcategoriaproducto"))
    @JsonIgnoreProperties("idproducto")
    private List<CategoriasProducto> idcategoriaproducto;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idimagen",referencedColumnName="idimagen")
    @JsonIgnoreProperties("idproducto")
    private Imagenes idimagen;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="iddimension", referencedColumnName="iddimension")
    @JsonIgnoreProperties("idproducto")
    private Dimensiones iddimension;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idcolor", referencedColumnName="idcolor")
    @JsonIgnoreProperties("idproducto")
    private Colores idcolor;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="idproducto")
    @JsonIgnoreProperties("idproducto")
    private List<Calificaciones> idcalificacion; 
    
    @OneToOne(mappedBy="idproducto")
    @JsonIgnoreProperties("idproducto")
    private ProductosPalabrasClave idproductospalabrasclave;
    
    @OneToMany(mappedBy="idproducto")
    @JsonIgnoreProperties("idproducto")
    private List<DetallesPedido> iddetallepedido;
    
}
