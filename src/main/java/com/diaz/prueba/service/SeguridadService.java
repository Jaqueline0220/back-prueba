package com.diaz.prueba.service;

import com.diaz.prueba.model.SeguridadModel;

import org.springframework.security.core.userdetails.UserDetails;

public interface SeguridadService {

	SeguridadModel  LoginUser(SeguridadModel obj_seguridad);
	UserDetails  UserByUsername(String username);
}
