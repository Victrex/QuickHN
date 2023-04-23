/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
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
@Table(name="Clientes")
@IdClass(Personas.class)
public class Clientes implements Serializable{    
    @Id
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idcliente", referencedColumnName="idpersona")
    @JsonIgnoreProperties("idcliente")  //POSIBLE ERROR
    private Personas idcliente;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idusuario", referencedColumnName="idusuario")
    @JsonIgnoreProperties("idcliente")
    private Usuarios idusuario;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="idcliente")
    @JsonIgnoreProperties("idcliente")
    private List<Reclamos> idreclamo;
    
    @OneToMany(mappedBy="idcliente")
    @JsonIgnoreProperties("idcliente")
    private List<HistorialCompras> idhistorial;
}
