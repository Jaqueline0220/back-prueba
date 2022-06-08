package com.diaz.prueba.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.diaz.prueba.dao.TipoCambioDao;
import com.diaz.prueba.model.CorePersonaModel;
import com.diaz.prueba.model.MonedaModel;
import com.diaz.prueba.model.ResultModel;
import com.diaz.prueba.model.Request.FiltroRequest;
import com.diaz.prueba.model.Request.TipoCambioRequest;
import com.diaz.prueba.model.Response.TipoCambioResultModel;
import com.diaz.prueba.util.GenLogger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class TipoCambioDaoImpl extends JdbcDaoSupport implements TipoCambioDao{

    @Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Autowired
    private GenLogger genLogger;

    @Override
    public ResultModel<TipoCambioResultModel> guardarTipoCambio(TipoCambioRequest request) {
        ResultModel<TipoCambioResultModel> resultado = new ResultModel<TipoCambioResultModel>();
        try {
            String sql = "call prueba_bbva.spguardarResultado("
								+request.getIdTipoCambio()
								+",'"+request.getEstado()
								+"',"+request.getIdMonedaDe()
								+","+request.getIdMonedaPara()
                                +",'"+request.getMontoIngresado()
                                +"','"+request.getMontoSalida()
                                +"',"+request.getIdUsuario()+")";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            for (Map<String, Object> row : rows) {
                FiltroRequest param  = new FiltroRequest();
                param.setIdTipoCambio(request.getIdTipoCambio().equals(0)?((BigInteger) row.get("idtipocambio")).intValue():request.getIdTipoCambio());
                List<TipoCambioResultModel> obj = listarTipoCambio(param).getData();
                resultado.setData(obj);
                break;
			}
            resultado.setMessage(request.getIdTipoCambio().equals(0)?"Se registro correctamente":"Se actualizo correctamente");
            resultado.setIsSuccess(true);
        } catch (Exception e) {
            genLogger.loggError("TipoCambioDaoImpl", e.getMessage());
            resultado.setIsSuccess(false);
            resultado.setMessage(e.getMessage());
			return resultado;
        }
        return resultado;
    }

    @Override
    public ResultModel<TipoCambioResultModel> listarTipoCambio(FiltroRequest request) {
        ResultModel<TipoCambioResultModel> resultado = new ResultModel<TipoCambioResultModel>();
		try {
			String sql = "call prueba_bbva.spListarResultado("
								+request.getIdMonedaDe()
								+","+request.getIdMonedaPara()
								+","+request.getIdTipoCambio()+")";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            List<TipoCambioResultModel> list = new ArrayList<>();
			for (Map<String, Object> row : rows) {
				TipoCambioResultModel obj = new TipoCambioResultModel();
				obj.setMonedaIngreso((String) row.get("MonedaDe"));
				obj.setMonedaSalida((String) row.get("MonedaPara"));
                obj.setMontoIngresado((BigDecimal) row.get("montoIngresado"));
				obj.setMontoSalida((BigDecimal) row.get("montoSalida"));
				obj.setEstado((String) row.get("estado"));
				obj.setPersonaRegistro((String) row.get("personaRegistro"));
                obj.setFechaCreacion((LocalDateTime) row.get("fechaCreacion"));
				obj.setFechaModificacion((LocalDateTime) row.get("fechaModificacion"));
                obj.setPersonaActualizo((String) row.get("personaModifico"));
                obj.setIdTipoCambio((Integer) row.get("idTipoCambio"));
				list.add(obj);
			}
            resultado.setData(list);
            resultado.setIsSuccess(true);
            resultado.setMessage(list.size()>0?"Se listo correctamente":"No se encontraron resultados");
		} catch (Exception e) {
			genLogger.loggError("TipoCambioDaoImpl", e.getMessage());
            resultado.setIsSuccess(false);
            resultado.setMessage(e.getMessage());
			return resultado;
		}
		return resultado;
    }

    @Override
    public ResultModel<MonedaModel> listarMoneda() {
        ResultModel<MonedaModel> resultado = new ResultModel<MonedaModel>();
		try {
			String sql = "select * from prueba_bbva.moneda";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            List<MonedaModel> list = new ArrayList<>();
			for (Map<String, Object> row : rows) {
				MonedaModel obj = new MonedaModel();
				obj.setIdMoneda((Integer) row.get("idmoneda"));
				obj.setDescripcion((String) row.get("descripcion"));
                obj.setValor((BigDecimal) row.get("valor"));
				obj.setEstado((String) row.get("estado"));
                obj.setFechaCreacion((LocalDateTime) row.get("fechaCreacion"));
				obj.setFechaModificacion((LocalDateTime) row.get("fechaModificacion"));
				list.add(obj);
			}
            resultado.setData(list);
            resultado.setIsSuccess(true);
            resultado.setMessage(list.size()>0?"Se listo correctamente":"No se encontraron resultados");
		} catch (Exception e) {
			genLogger.loggError("TipoCambioDaoImpl", e.getMessage());
            resultado.setIsSuccess(false);
            resultado.setMessage(e.getMessage());
			return resultado;
		}
		return resultado;
    }

    @Override
    public ResultModel<CorePersonaModel> obtenerPersona() {
        ResultModel<CorePersonaModel> resultado = new ResultModel<CorePersonaModel>();
		try {
			String sql = "select c.*, l.usuario from prueba_bbva.corepersona c join prueba_bbva.login l "+
            "on c.idcorepersona=l.idcorepersona";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            List<CorePersonaModel> list = new ArrayList<>();
			for (Map<String, Object> row : rows) {
				CorePersonaModel obj = new CorePersonaModel();
				obj.setIdCorePersona((Integer) row.get("idcorepersona"));
				obj.setNombres((String) row.get("nombres"));
                obj.setApellidos((String) row.get("apellidos"));
				obj.setNumeroDocumento((String) row.get("numeroDocumento"));
				obj.setDireccion((String) row.get("direccion"));
				obj.setIdRol((Integer) row.get("idrol"));
                obj.setFechaCreacion((LocalDateTime) row.get("fechaCreacion"));
				obj.setFechaModificacion((LocalDateTime) row.get("fechaModificacion"));
                obj.setUsuario((String) row.get("usuario"));
				list.add(obj);
			}
            resultado.setData(list);
            resultado.setIsSuccess(true);
            resultado.setMessage(list.size()>0?"Se listo correctamente":"No se encontraron resultados");
		} catch (Exception e) {
			genLogger.loggError("TipoCambioDaoImpl", e.getMessage());
            resultado.setIsSuccess(false);
            resultado.setMessage(e.getMessage());
			return resultado;
		}
		return resultado;
    }
    
}
