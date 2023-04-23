/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Soriano
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "palabrasclave")
public class PalabrasClave implements Serializable {

    @Id
    private String idpalabraclave;
    
    private String palabra;

    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "productospalabrasclave",/* ---CREAR ESTA TABLA EN LA BASE DE DATOS--- */
            joinColumns = @JoinColumn(name = "idpalabraclave"),
            inverseJoinColumns = @JoinColumn(name = "idproducto"))
    @JsonIgnoreProperties("idpalabraclave")
    private List<Productos> idproducto;
}
