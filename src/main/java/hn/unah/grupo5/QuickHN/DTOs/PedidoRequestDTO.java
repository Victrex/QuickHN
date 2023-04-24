/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Kenne
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {
    @JsonProperty
    private PedidosDTO pedido;
    @JsonProperty
    private List<DetallesPedidoDTO> detallesPedido;
}
