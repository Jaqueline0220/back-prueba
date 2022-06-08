package com.diaz.prueba.model;

public class CorePersonaModel extends AuditoriaModel{
    private Integer idCorePersona;
    private String nombres;
    private String apellidos;
    private String numeroDocumento;
    private String direccion;
    private Integer idRol;
    private String usuario;

    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Integer getIdCorePersona() {
        return idCorePersona;
    }
    public void setIdCorePersona(Integer idCorePersona) {
        this.idCorePersona = idCorePersona;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getIdRol() {
        return idRol;
    }
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    } 

    
}
