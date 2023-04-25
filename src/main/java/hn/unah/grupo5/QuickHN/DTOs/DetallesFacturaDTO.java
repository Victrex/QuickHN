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
 * @author Soriano
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallesFacturaDTO {

    @JsonProperty
    private String iddetallefactura;
    //@JsonProperty
    private int cantidad = 1;
    //@JsonProperty
    private float preciounitario;
    //@JsonProperty
    private float total;
    @JsonProperty
    private String iddetallepedido;
    //@JsonProperty
    private String idfactura;

}
