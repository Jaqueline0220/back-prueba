package com.diaz.prueba.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diaz.prueba.model.CorePersonaModel;
import com.diaz.prueba.model.MonedaModel;
import com.diaz.prueba.model.ResultModel;
import com.diaz.prueba.model.Request.FiltroRequest;
import com.diaz.prueba.model.Request.TipoCambioRequest;
import com.diaz.prueba.model.Response.TipoCambioResultModel;
import com.diaz.prueba.service.TipoCambioService;
import com.diaz.prueba.util.GenLogger;

import io.swagger.annotations.Authorization;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tipocambio")
@ComponentScan("com.diaz.prueba.service.impl, com.diaz.prueba.dao.impl")
public class TipoCambioApi {
    @Autowired
    private TipoCambioService tipoService;

	@Autowired
    private GenLogger genLogger;

    @GetMapping("/listarMoneda")
    @ApiOperation(value = "Listado de monedas", authorizations = {@Authorization(value="JWT")})
    @ApiResponses({ @ApiResponse(code = 200, message = "Resuelto correctamente"),@ApiResponse(code = 404, message = "No encontrado") })
    public ResponseEntity<ResultModel<MonedaModel>> listarMoneda() {
        ResultModel<MonedaModel> result = new ResultModel<MonedaModel>();
        try {
            result = tipoService.listarMoneda();
            if(!result.getIsSuccess()){
                return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
            }
            genLogger.loggInfo(" TipoCambioApi - listarMoneda", "Se obtuvo correctamente");
           return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception Ex) {
            genLogger.loggError(" TipoCambioApi - listarMoneda",
                    "Ocurrio un error al obtener en: " + Ex.getMessage());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/obtenerPersona/{usuario}")
    @ApiOperation(value = "Listado de monedas", authorizations = {@Authorization(value="JWT")})
    @ApiResponses({ @ApiResponse(code = 200, message = "Resuelto correctamente"),@ApiResponse(code = 404, message = "No encontrado") })
    public ResponseEntity<ResultModel<CorePersonaModel>> obtenerPersona(@PathVariable("usuario") String usuario) {
        ResultModel<CorePersonaModel> result = new ResultModel<CorePersonaModel>();
        try {
            result = tipoService.obtenerPersona(usuario);
            if(!result.getIsSuccess()){
                return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
            }
            genLogger.loggInfo(" TipoCambioApi - obtenerPersona", "Se obtuvo correctamente");
           return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception Ex) {
            genLogger.loggError(" TipoCambioApi - obtenerPersona",
                    "Ocurrio un error al obtener en: " + Ex.getMessage());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PostMapping("/guardarTipoCambio")
    @ApiOperation(value = "Guardar tipo de cambio", authorizations = {@Authorization(value="JWT")})
    @ApiResponses({ @ApiResponse(code = 200, message = "Resuelto correctamente"),@ApiResponse(code = 404, message = "No encontrado") })
    public ResponseEntity<ResultModel<TipoCambioResultModel>> guardarTipoCambio(@RequestBody TipoCambioRequest request) {
        ResultModel<TipoCambioResultModel> result = new ResultModel<TipoCambioResultModel>();
        try {
            result = tipoService.guardarTipoCambio(request);
            if(!result.getIsSuccess()){
                return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
            }
            genLogger.loggInfo(" TipoCambioApi - guardarTipoCambio", "Se obtuvo correctamente");
           
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception Ex) {
            genLogger.loggError(" TipoCambioApi - guardarTipoCambio",
                    "Ocurrio un error al obtener en: " + Ex.getMessage());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PostMapping("/listarTipoCambio")
    @ApiOperation(value = "Listar tipo de cambio", authorizations = {@Authorization(value="JWT")})
    @ApiResponses({ @ApiResponse(code = 200, message = "Resuelto correctamente"),@ApiResponse(code = 404, message = "No encontrado") })
    public ResponseEntity<ResultModel<TipoCambioResultModel>> listarTipoCambio(@RequestBody FiltroRequest request) {
        ResultModel<TipoCambioResultModel> result = new ResultModel<TipoCambioResultModel>();
        try {
            result = tipoService.listarTipoCambio(request);
            if(!result.getIsSuccess()){
                return new ResponseEntity<>(result, HttpStatus.BAD_GATEWAY);
            }
            genLogger.loggInfo(" TipoCambioApi - listarTipoCambio", "Se obtuvo correctamente");
           
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception Ex) {
            genLogger.loggError(" TipoCambioApi - listarTipoCambio",
                    "Ocurrio un error al obtener en: " + Ex.getMessage());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}
