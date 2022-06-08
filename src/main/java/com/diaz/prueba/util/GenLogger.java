package com.diaz.prueba.util;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class GenLogger {
      
    public void loggInfo(String origen, String msj){
        Logger logger = LoggerFactory.getLogger(origen);

        logger.info(msj);
    }
    public void loggWarn(String origen, String msj){
        Logger logger = LoggerFactory.getLogger(origen);
        logger.warn(msj);
    }
    public void loggError(String origen, String msj){
        Logger logger = LoggerFactory.getLogger(origen);

        logger.error(msj);
    }
}
