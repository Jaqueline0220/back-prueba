package com.diaz.prueba.model;

import java.math.BigDecimal;

public class MonedaModel extends AuditoriaModel{
    private Integer idMoneda;
    private String descripcion;
    private BigDecimal valor;
    

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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
