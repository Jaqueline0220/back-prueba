package com.diaz.prueba.model;

import java.math.BigDecimal;

public class TipoCambioModel extends AuditoriaModel{
    private Integer idTipoCambio;
    private String descripcion;
    private BigDecimal valor;
    private Integer idMoneda;
    
    public Integer getIdTipoCambio() {
        return idTipoCambio;
    }
    public void setIdTipoCambio(Integer idTipoCambio) {
        this.idTipoCambio = idTipoCambio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Integer getIdMoneda() {
        return idMoneda;
    }
    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    
   
}
