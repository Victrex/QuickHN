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
public class FacturasDTO {
    @JsonProperty
    private String idfactura;
    @JsonProperty
    private Date fechalimite;
    @JsonProperty
    private String rangosolicitudSAR;
    @JsonProperty
    private int numfactura;
    @JsonProperty
    private float subtotal;
    @JsonProperty
    private String idisv;
    @JsonProperty
    private float total;
    @JsonProperty
    private Date fechaemision;
    @JsonProperty
    private String idproveedor;
    @JsonProperty
    private String idsolicitudsar;
    @JsonProperty
    private String idporcentajecomision;
    @JsonProperty
    private String iddetallefactura;
}
