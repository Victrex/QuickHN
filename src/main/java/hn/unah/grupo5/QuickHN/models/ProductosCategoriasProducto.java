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
import lombok.Data;

/**
 *
 * @author Soriano
 */
@Entity
@Data
@Table(name = "productoscategoriasproducto")
@IdClass(ProductosCategoriasProductoID.class)
public class ProductosCategoriasProducto implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @JsonIncludeProperties("idproducto")
    private Productos idproducto;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcategoriaproducto", referencedColumnName = "idcategoriaproducto")
    @JsonIncludeProperties("idcategoriaproducto")
    private CategoriasProducto idcategoriaproducto;
}
