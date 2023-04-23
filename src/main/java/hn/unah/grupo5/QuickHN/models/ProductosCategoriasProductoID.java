/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Soriano
 */
@Data
public class ProductosCategoriasProductoID implements Serializable{
    private String idproducto;
    private String idcategoriaproducto;
}
