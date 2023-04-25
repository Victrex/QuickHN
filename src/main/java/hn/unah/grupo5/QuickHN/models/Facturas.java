/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "Facturas")
public class Facturas implements Serializable {

    @Id
    private String idfactura;

    @Column(name = "rangosolicitudSAR")
    private String rangosolicitudSAR;
    private String numfactura;
    private float subtotal;
    private float total;
    private Date fechaemision;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @JsonIncludeProperties({"idproveedor","nombre"})
    private Proveedores idproveedor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idsolicitudsar", referencedColumnName = "idsolicitudsar")
    @JsonIncludeProperties({"idsolicitudsar","numcaiempresa","fechalimite"})
    private SolicitudesSAR idsolicitudsar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idporcentajecomision", referencedColumnName = "idporcentajecomision")
    @JsonIncludeProperties("porcentaje")
    private PorcentajeComisiones idporcentajecomision;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idisv", referencedColumnName = "idisv")
    @JsonIncludeProperties("isv")
    private Isv idisv;

    //Atributos de relaciones(no son atributos existentes en la tabla de la BD)
    @OneToMany(mappedBy = "idfactura")
    @JsonIncludeProperties("iddetallefactura")
    private List<DetallesFactura> iddetallefactura;

}
