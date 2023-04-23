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
public class CategoriasProductoDTO {

    @JsonProperty
    private String idcategoriaproducto;
    @JsonProperty
    private String nombre;
    @JsonProperty
    private String descripcion;
    @JsonProperty
    private String idimagen;
}
