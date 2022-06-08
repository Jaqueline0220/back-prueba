package com.diaz.prueba.service;

import com.diaz.prueba.model.CorePersonaModel;
import com.diaz.prueba.model.MonedaModel;
import com.diaz.prueba.model.ResultModel;
import com.diaz.prueba.model.Request.FiltroRequest;
import com.diaz.prueba.model.Request.TipoCambioRequest;
import com.diaz.prueba.model.Response.TipoCambioResultModel;

public interface TipoCambioService {
    ResultModel<TipoCambioResultModel> guardarTipoCambio(TipoCambioRequest request);
    ResultModel<TipoCambioResultModel> listarTipoCambio(FiltroRequest request);
    ResultModel<MonedaModel> listarMoneda();
    ResultModel<CorePersonaModel> obtenerPersona(String usuario);
}
