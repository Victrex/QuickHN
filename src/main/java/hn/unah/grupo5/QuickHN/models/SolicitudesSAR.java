/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
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
    private String idsolicitudsar; 
    private String numcaiempresa;
    private Date fechalimite;
    private int correlativoactual;
    private int numeroinicial;
    private int numerofinal;
    private float isv;
    
    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idestablecimiento", referencedColumnName="idestablecimiento")
    @JsonIgnoreProperties("idsolicitudsar")
    private Establecimiento idestablecimiento;

    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idpuntoemision", referencedColumnName="idpuntoemision")
    @JsonIgnoreProperties("idsolicitudsar")
    private PuntoEmision idpuntoemision;

    @ManyToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name="idtipodocumento", referencedColumnName="idtipodocumento")
    @JsonIgnoreProperties("idsolicitudsar")
    private TipoDocumento idtipodocumento;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idimagen",referencedColumnName="idimagen")
    @JsonIgnoreProperties("idsolicitudsar")
    private Imagenes idimagen;
    
    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)    
    @OneToMany(mappedBy="idsolicitudsar")
    @JsonIgnoreProperties("idsolicitudsar")
    private List<Facturas> idfactura;
}
