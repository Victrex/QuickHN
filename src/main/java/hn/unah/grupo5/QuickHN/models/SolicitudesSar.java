/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="SolicitudesSAR")
public class SolicitudesSAR implements Serializable {
    @Id
    private String idsolicitudsar; //Identificar Relación
    private String numcaiempresa;
    private Date fechalimite;
    private int correlativoactual;
    private int numeroinicial;
    private int numerofinal;
    private float isv;
    
    //Identificar Relación
    private Establecimiento idestablecimiento;

    //Identificar Relación
    private PuntoEmision idpuntoemision;

    //Identificar Relación
    private TipoDocumento idtipodocumento;

    //Identificar Relación
    private Imagenes idimagen;

}
