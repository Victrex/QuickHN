/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="Colonias")
public class Colonias implements Serializable{
    @Id
    private String idcolonia;
    private String nombre;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idmunicipio", referencedColumnName="idmunicipio")
    @JsonIncludeProperties("idmunicipio")
    private Municipios idmunicipio;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="idcolonia")
    @JsonIncludeProperties("iddireccion")
    private List<Direcciones> iddireccion;
}
