package com.diaz.prueba.dao.impl;


import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.diaz.prueba.dao.SeguridadDao;
import com.diaz.prueba.model.SeguridadModel;
import com.diaz.prueba.util.Encrypt;
import com.diaz.prueba.util.GenLogger;

@Repository
public class SeguridadDaoImpl  extends JdbcDaoSupport implements SeguridadDao{
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Autowired
    private GenLogger genLogger;
	
	@Override
	public SeguridadModel LoginUser(SeguridadModel obj_seguridad) {
		String pass=null;
		try {
			pass = Encrypt.harden(obj_seguridad.getPassword());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		SeguridadModel usuario= null;
		String sql = "call prueba_bbva.spValidarContrasenia('"+obj_seguridad.getUsername()+"','"+pass+"')";
		
		try {
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			SeguridadModel result = new SeguridadModel();
			if (rows.size()==1) {
				for(Map<String, Object> row:rows){
					SeguridadModel segu = new SeguridadModel();
					segu.setUsername((String)row.get("usuario"));
					segu.setPassword((String)row.get("contrasenia"));
					result= segu;
				}
			}
			return result;
		} catch (Exception e) {
			genLogger.loggError("SeguridadDaoImpl",e.getMessage());
			return usuario;
		}
		
	}

	@Override
	public SeguridadModel UserByUsername(String username) {
		SeguridadModel usuario= null;
		String sql = "call prueba_bbva.spValidarContrasenia('"+username+"',null)";
		
		try {
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			SeguridadModel result = new SeguridadModel();
			if (rows.size()==1) {
				for(Map<String, Object> row:rows){
					SeguridadModel segu = new SeguridadModel();
					segu.setUsername((String)row.get("usuario"));
					segu.setPassword((String)row.get("contrasenia"));
					result= segu;
				}
			}
			String pass=Encrypt.soften(result.getPassword());
			result.setPassword(pass);
			
			return result;
		} catch (Exception e) {
			genLogger.loggError("SeguridadDaoImpl",e.getMessage());
			return usuario;
		}
	}

}
