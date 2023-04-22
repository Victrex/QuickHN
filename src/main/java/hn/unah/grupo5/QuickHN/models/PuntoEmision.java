/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author mcenteno
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PuntoEmision")
public class PuntoEmision implements Serializable {
    @Id
    private String idpuntoemision; //Identificar Relación
    private String valor;

    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="idpuntoemision")
    @JsonIgnoreProperties("idpuntoemision")
    private List<SolicitudesSAR> idsolicitudsar;
}
