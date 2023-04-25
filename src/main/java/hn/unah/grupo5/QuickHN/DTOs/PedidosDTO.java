/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
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
public class PedidosDTO {
    @JsonProperty
    private String idpedido;
    @JsonProperty
    private Date fechapedido;

    private float subtotal;
    @JsonProperty
    private String idisv;

    private float total;
    @JsonProperty
    private String idusuario;
    @JsonProperty
    private String iddireccionentrega;
    
    
}
