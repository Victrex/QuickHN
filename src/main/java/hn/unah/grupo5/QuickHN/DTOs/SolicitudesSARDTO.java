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
public class SolicitudesSARDTO {
    @JsonProperty
    private String idsolicitudsar;
    @JsonProperty 
    private String numcaiempresa;
    @JsonProperty
    private Date fechalimite;
    @JsonProperty
    private int correlativoactual;
    @JsonProperty
    private int numeroinicial;
    @JsonProperty
    private int numerofinal;

    @JsonProperty
    private String idestablecimiento;
    @JsonProperty
    private String idpuntoemision;
    @JsonProperty
    private String idtipodocumento;
    @JsonProperty
    private String idimagen;
    
}
