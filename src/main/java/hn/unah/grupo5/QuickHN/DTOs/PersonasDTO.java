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
public class PersonasDTO {
    @JsonProperty
    private String idpersona;  
    @JsonProperty
    private String identidad;
    @JsonProperty
    private String nombre1;
    @JsonProperty
    private String nombre2;
    @JsonProperty
    private String apellido1;
    @JsonProperty
    private String apellido2;
    @JsonProperty
    private String correoelectronico;
    @JsonProperty
    private String telefono;
    @JsonProperty
    private String iddireccion;
    
}
