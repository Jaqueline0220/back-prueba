package com.diaz.prueba.model.Request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TipoCambioRequest {
    private Integer idMonedaDe;
    private Integer idMonedaPara;
    private BigDecimal montoIngresado;
    private BigDecimal montoSalida;
    private String Estado;
    private Integer idUsuario;
    private Integer idTipoCambio;
}
