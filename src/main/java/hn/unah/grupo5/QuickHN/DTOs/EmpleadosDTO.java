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
public class EmpleadosDTO {
    @JsonProperty
    private String idempleado;
    @JsonProperty
    private float sueldo;
    @JsonProperty
    private Date fechacontratacion;
    @JsonProperty
    private String idsucursal;
    @JsonProperty
    private String idimagen;
            
    
}
