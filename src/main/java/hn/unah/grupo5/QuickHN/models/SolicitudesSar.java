/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
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
@Table(name="SolicitudesSar")
public class SolicitudesSar implements Serializable {
    @Id
    private String idsolicitudsar; //Identificar Relación
    
    @Column(name="fechalimite")
    private Date fechalimite;

    //Identificar Relación
    @Column(name="idestablecimiento")
    private String idestablecimiento;

    //Identificar Relación
    @Column(name="idpuntoemision")
    private String idpuntoemision;

    //Identificar Relación
    @Column(name="idtipodocumento")
    private String idtipodocumento;

    @Column(name="correlativoactual")
    private int correlativoactual;

    @Column(name="numeroinicial")
    private int numeroinicial;

    @Column(name="numerofinal")
    private int numerofinal;

    @Column(name="isv")
    private float isv;

    //Identificar Relación
    @Column(name="idimagen")
    private String idimagen;

}
