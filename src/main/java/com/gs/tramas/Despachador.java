package com.gs.tramas;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;

public class Despachador {

	public RespuestaBean enviar(EntradaBean entrada) throws Exception{
        RespuestaBean respuesta = new RespuestaBean();

        FarmaParserTramas farmaParserTramas = new FarmaParserTramas();
        IsoMessage iso = new IsoMessage();
        MessageFactory mfact;
        mfact = ConfigParser.createFromClasspathConfig(Constantes.FILE_CONFIG);
        iso = farmaParserTramas.generarTrama(entrada);
        
        LectorBitmaps.imprimirVariablesParseadas(iso);
        String tramaIn = new String(iso.writeData());
        respuesta.setTramaIn(tramaIn);
        
        System.out.println("TAMANIO TRAMA IN COMPLETA JUSTO ANTES DE ENVIAR: " + tramaIn );
            //ERIOS 28.01.2014 Control de respuesta
            /*String tramaOut = enviarTrama(tramaIn);
            
            respuesta.setTramaOut(tramaOut);
            
            log.debug("TAMANIO TRAMA OUT: " + tramaOut.getBytes().length );
            log.debug("TRAMA OUT: '"+tramaOut+"'");
            byte[] byteTramaOut = tramaOut.getBytes();
            log.debug("ANTES DEL ERROR");
            IsoMessage im = mfact.parseMessage(byteTramaOut ,0);
            log.debug("DESPUES DEL ERROR");
            imprimirVariablesParseadas(im);
            respuesta.setIm(im);
            respuesta.setEntrada(entrada);
            respuesta.cargarRespuesta();*/
        
        return respuesta;
    }
	
}
