package com.diaz.prueba.model.Request;

import lombok.Data;

@Data
public class FiltroRequest {
    private Integer idMonedaDe;
    private Integer idMonedaPara;
    private Integer idTipoCambio;
}
