package com.diaz.prueba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.diaz.prueba.dao.SeguridadDao;
import com.diaz.prueba.model.SeguridadModel;
import com.diaz.prueba.service.SeguridadService;

@Service
public class SeguridadServiceImpl implements SeguridadService,UserDetailsService {

	@Autowired
	SeguridadDao seguridadDao;

	@Override
	public SeguridadModel LoginUser(SeguridadModel obj_seguridad) {
		return seguridadDao.LoginUser(obj_seguridad);
	}

	@Override
	public UserDetails UserByUsername(String username) throws UsernameNotFoundException {
		SeguridadModel usuariologueado = seguridadDao.UserByUsername(username);
		return new User(usuariologueado.getUsername(), usuariologueado.getPassword(), new ArrayList<>());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SeguridadModel usuariologueado = seguridadDao.UserByUsername(username);
        return new User(usuariologueado.getUsername(),usuariologueado.getPassword(),new ArrayList<>());
	}

}
