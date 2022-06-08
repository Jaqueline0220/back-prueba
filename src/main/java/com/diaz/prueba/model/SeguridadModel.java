package com.diaz.prueba.model;

import java.io.Serializable;

public class SeguridadModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    public String token;
    public String mensaje;

    public SeguridadModel() {
    }

    public SeguridadModel(String username, String password, String token, String mensaje) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.mensaje = mensaje;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
