/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
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
@Table(name="Personas")
public class Personas implements Serializable{    
    @Id
    @Column(name="idpersona")
    private String idpersona;    
    
    private String identidad;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String correoelectronico;
    private String telefono;
    
//    @OneToMany(mappedBy="idpersona")
//    @JsonIgnoreProperties("idpersona")
//    private List<Direcciones> iddireccion;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
//    @OneToOne(mappedBy="idpersona")
//    private Empleados idempleado;
//    
//    @OneToOne(mappedBy="idpersona")
//    private Clientes idcliente;
}
