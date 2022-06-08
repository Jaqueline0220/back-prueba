package com.diaz.prueba.dao;

import com.diaz.prueba.model.SeguridadModel;

public interface SeguridadDao {
	 SeguridadModel LoginUser(SeguridadModel obj_seguridad);
	 SeguridadModel  UserByUsername(String username);
}
