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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Kenne
 */
@Entity
@Data
@Table(name="ProductosPalabrasClave")
@IdClass(ProductosPalabrasClaveID.class)
public class ProductosPalabrasClave implements Serializable{
    @Id
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idpalabraclave", referencedColumnName="idpalabraclave")
    @JsonIgnoreProperties("idpalabraclave")
    private PalabrasClave idpalabraclave;
    
    @Id
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idproducto", referencedColumnName="idproducto")
    @JsonIgnoreProperties("idproducto")
    private Productos idproducto;
}
