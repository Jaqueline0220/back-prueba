package com.diaz.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaz.prueba.dao.TipoCambioDao;
import com.diaz.prueba.model.CorePersonaModel;
import com.diaz.prueba.model.MonedaModel;
import com.diaz.prueba.model.ResultModel;
import com.diaz.prueba.model.Request.FiltroRequest;
import com.diaz.prueba.model.Request.TipoCambioRequest;
import com.diaz.prueba.model.Response.TipoCambioResultModel;
import com.diaz.prueba.service.TipoCambioService;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    
    @Autowired
	TipoCambioDao tipoCambioDao;

    @Override
    public ResultModel<TipoCambioResultModel> guardarTipoCambio(TipoCambioRequest request) {
        return tipoCambioDao.guardarTipoCambio(request);
    }

    @Override
    public ResultModel<TipoCambioResultModel> listarTipoCambio(FiltroRequest request) {
        return tipoCambioDao.listarTipoCambio(request);
    }

    @Override
    public ResultModel<MonedaModel> listarMoneda() {
        return tipoCambioDao.listarMoneda();
    }

    @Override
    public ResultModel<CorePersonaModel> obtenerPersona(String usuario) {
        return tipoCambioDao.obtenerPersona();
    }
    
}
