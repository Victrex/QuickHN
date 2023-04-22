/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Kenne
 */
@Data
public class ProductosPalabrasClaveID implements Serializable{
    //@Column(insertable=false,updatable=false)
    private String idpalabraclave;
    private String idproducto;
}
