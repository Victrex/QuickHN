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
@Table(name="Municipios")
public class Municipios implements Serializable{
    @Id
    private String idmunicipio;
    private String nombre;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="iddepartamento", referencedColumnName="iddepartamento")
    @JsonIgnoreProperties("idmunicipio")
    private Departamentos iddepartamento;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy="idmunicipio")
    @JsonIgnoreProperties("idmunicipio")
    private List<Colonias> idcolonia;
    
    @OneToMany(mappedBy="idmunicipio")
    @JsonIgnoreProperties("idmunicipio")
    private List<Direcciones> iddireccion;
    
}
