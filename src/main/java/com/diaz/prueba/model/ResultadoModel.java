package com.diaz.prueba.model;

import java.math.BigDecimal;



public class ResultadoModel extends AuditoriaModel{
    private Integer idResultado;
    private Integer idTipoCambioDe;
    private Integer idTipoCambioPara;
    private BigDecimal montoIngresado;
    private BigDecimal montoResultado;

    public Integer getIdResultado() {
        return idResultado;
    }
    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }
    public Integer getIdTipoCambioDe() {
        return idTipoCambioDe;
    }
    public void setIdTipoCambioDe(Integer idTipoCambioDe) {
        this.idTipoCambioDe = idTipoCambioDe;
    }
    public Integer getIdTipoCambioPara() {
        return idTipoCambioPara;
    }
    public void setIdTipoCambioPara(Integer idTipoCambioPara) {
        this.idTipoCambioPara = idTipoCambioPara;
    }
    public BigDecimal getMontoIngresado() {
        return montoIngresado;
    }
    public void setMontoIngresado(BigDecimal montoIngresado) {
        this.montoIngresado = montoIngresado;
    }
    public BigDecimal getMontoResultado() {
        return montoResultado;
    }
    public void setMontoResultado(BigDecimal montoResultado) {
        this.montoResultado = montoResultado;
    }

    
}
