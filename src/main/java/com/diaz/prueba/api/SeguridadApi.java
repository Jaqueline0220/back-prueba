package com.diaz.prueba.api;

import com.diaz.prueba.model.SeguridadModel;
import com.diaz.prueba.service.SeguridadService;
import com.diaz.prueba.util.GenLogger;
import com.diaz.prueba.util.TokenConfig;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/autenticacion")
@ComponentScan("com.diaz.prueba.service.impl, com.diaz.prueba.dao.impl")
public class SeguridadApi {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private SeguridadService login;

    @Autowired
    private TokenConfig  tokenConfig;

	@Autowired
    private GenLogger genLogger;

    @PostMapping("/token")
	@ApiResponses({ @ApiResponse(code = 200, message = "Resuelto correctamente"), @ApiResponse(code = 404, message = "No encontrado") })
    public ResponseEntity<SeguridadModel> Token(@RequestBody SeguridadModel seguridad){
    	try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(seguridad.getUsername(),seguridad.getPassword()));
    		 SeguridadModel usuariologueado = login.LoginUser(seguridad);
    		 if(usuariologueado.getUsername() !=null) {
    			 UserDetails userDetails= new User(usuariologueado.getUsername(),usuariologueado.getPassword(),new ArrayList<>());
        		 String token = tokenConfig.genToken(userDetails);
				 genLogger.loggInfo("SeguridadApi - Token", "Token generado");
        		 return  new ResponseEntity<>( new SeguridadModel(seguridad.getUsername(),null,token,"Token generado") ,HttpStatus.OK ); 
    		 }else {
				 genLogger.loggWarn("SeguridadApi - Token", "Las credenciales son incorrectas");
				 return new ResponseEntity<>( new SeguridadModel(seguridad.getUsername(),seguridad.getPassword(),"","Las credenciales son incorrectas") ,HttpStatus.OK ); 
    		 }
    	} catch (Exception Ex){
			genLogger.loggError("SeguridadApi - Token", "Ocurrio un error al generar el token en: "+Ex.getMessage());
    		return new ResponseEntity<>( new SeguridadModel(seguridad.getUsername(),seguridad.getPassword(),"","Ocurrio un error al generar el token en: "+Ex.getMessage()),HttpStatus.FORBIDDEN);    		
    	}
    }
}
