/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kenne
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Calificaciones")
public class Calificaciones implements Serializable{    
    @Id
    private String idcalificacion;
    
    @Column(name="calificacion")
    private int calificacion;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idproducto", referencedColumnName="idproducto")
    @JsonIgnoreProperties("idcalificacion")
    private Productos idproducto;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idusuario", referencedColumnName="idusuario")
    @JsonIgnoreProperties("idcalificacion")
    private Usuarios idusuario;
}


