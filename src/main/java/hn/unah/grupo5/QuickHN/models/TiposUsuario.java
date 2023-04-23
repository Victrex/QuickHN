/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * @author Kenne
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tiposusuario")
public class TiposUsuario {
    
    @Id
    private String idtipousuario;
    
    private String descripcion;
    
//    @OneToMany(mappedBy="idtipousuario")
//    @JsonIgnoreProperties("idtipousuario")
//    private List<Usuarios> idusuario;
}
