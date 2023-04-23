/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Pinedas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDTO {
    @JsonProperty
    private String idproducto;
    @JsonProperty
    private String idproveedor;
    @JsonProperty
    private String nombreproducto;
    @JsonProperty
    private String descripcion;
    @JsonProperty
    private float precio;
    @JsonProperty
    private String idcategoriaproducto;
    @JsonProperty
    private int stockdisponible;
    @JsonProperty
    private float pesoproducto;
    @JsonProperty
    private String modeloproducto;
    @JsonProperty
    private String marcaproducto;
    @JsonProperty
    private int cantdiasgarantia;
    @JsonProperty
    private String idimagen;
    @JsonProperty
    private String iddimension;
    @JsonProperty
    private String idcolor;

}
