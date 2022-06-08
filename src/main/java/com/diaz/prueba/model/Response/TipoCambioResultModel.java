package com.diaz.prueba.model.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class TipoCambioResultModel {
    private String monedaIngreso;
    private String monedaSalida;
    private BigDecimal montoIngresado;
    private BigDecimal montoSalida;
    private String estado;
    private String personaRegistro;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String personaActualizo;

    private Integer idTipoCambio;

    
    public Integer getIdTipoCambio() {
        return idTipoCambio;
    }
    public void setIdTipoCambio(Integer idTipoCambio) {
        this.idTipoCambio = idTipoCambio;
    }
    public String getMonedaIngreso() {
        return monedaIngreso;
    }
    public void setMonedaIngreso(String monedaIngreso) {
        this.monedaIngreso = monedaIngreso;
    }
    public String getMonedaSalida() {
        return monedaSalida;
    }
    public void setMonedaSalida(String monedaSalida) {
        this.monedaSalida = monedaSalida;
    }
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public String getPersonaActualizo() {
        return personaActualizo;
    }
    public void setPersonaActualizo(String personaActualizo) {
        this.personaActualizo = personaActualizo;
    }
    public BigDecimal getMontoIngresado() {
        return montoIngresado;
    }
    public void setMontoIngresado(BigDecimal montoIngresado) {
        this.montoIngresado = montoIngresado;
    }
    public BigDecimal getMontoSalida() {
        return montoSalida;
    }
    public void setMontoSalida(BigDecimal montoSalida) {
        this.montoSalida = montoSalida;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPersonaRegistro() {
        return personaRegistro;
    }
    public void setPersonaRegistro(String personaRegistro) {
        this.personaRegistro = personaRegistro;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
