/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Soriano
 */
@Entity
@Data
@Table(name="productoscategoriasproducto")
@IdClass(ProductosCategoriasProductoID.class)
public class ProductosCategoriasProducto implements Serializable{
    @Id
    private Productos idproducto;
    
    @Id
    private CategoriasProducto idcategoriaproducto;
}
