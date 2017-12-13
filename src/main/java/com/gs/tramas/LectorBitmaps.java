package com.gs.tramas;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.MessageFactory;
import com.solab.iso8583.parse.ConfigParser;

import java.io.IOException;
import java.text.ParseException;

public class LectorBitmaps {

	static void verTrama(String trama){
        MessageFactory mfact;
        byte[] byteTramaOut = trama.getBytes();
        IsoMessage im;
        try {
            //mfact = ConfigParser.createDefault();
            mfact = ConfigParser.createFromClasspathConfig("config.xml");
            im = mfact.parseMessage(byteTramaOut ,0);
            imprimirVariablesParseadas(im);
        } catch (IOException e) {
        //} catch (UnsupportedEncodingException ex) {
        } catch (ParseException ex1) {
        } catch (Exception ex2) {
        }
    }
	
	public static void imprimirVariablesParseadas(IsoMessage m)throws Exception {
        /*log.debug("TYPE: " + Integer.toHexString(m.getType()));*/
        for (int i = 0; i <= 128; i++){
            if (m.hasField(i)){
                System.out.println("F " + i + " (" + m.getField(i).getType().toString() + "): " + m.getObjectValue(i) + " -> '" + m.getField(i).toString() + "'");
            }
        }
    }
	
	public static Trama210 cargarRespuesta(String trama) throws Exception{
		
		MessageFactory mfact;
        byte[] byteTramaOut = trama.getBytes();
        IsoMessage im = null;
        try {
            //mfact = ConfigParser.createDefault();
            mfact = ConfigParser.createFromClasspathConfig("config.xml");
            im = mfact.parseMessage(byteTramaOut ,0);
            imprimirVariablesParseadas(im);
        //} catch (IOException e) {
        //} catch (UnsupportedEncodingException ex) {
        //} catch (ParseException ex1) {
        } catch (Exception ex2) {
        	ex2.printStackTrace();
        }
        
        
		Trama210 tabla = new Trama210();
        if (im.hasField(7)){
        	tabla.setField7(im.getField(7).toString());
        }
        /*if (im.hasField(38)){
            setCodAutorizacion(im.getObjectValue(38).toString());
        }
        if (im.hasField(39)){
            setResponseCode(im.getObjectValue(39).toString());
        }
        if (im.hasField(48) ){
            String rptaDE48 = im.getObjectValue(48).toString().trim();
            int i = 216;
            if(entrada.getTipoMensaje().equals(Constantes.MSG_400)){
                if(entrada.getTipoRecaudacion().equals(Constantes.TIPO_RECAUD_MOVISTAR)){
                    if(entrada.getTipoTrnscc().equals(Constantes.TRNS_RECARGA)){
                        setCodOperacion(rptaDE48.substring(i, rptaDE48.length()));
                    }
                }
            }
        }
        if (im.hasField(121) ){
            String rptaDE121 = im.getObjectValue(121).toString().trim();
            int i = 2;
            //if(entrada.getTipoMensaje().equals(Constantes.MSG_200)){
                if(entrada.getTipoRecaudacion().equals(Constantes.TIPO_RECAUD_CLARO)){
                    if(entrada.getTipoTrnscc().equals(Constantes.TRNS_RECARGA)){
                        setNumeroRecarga(rptaDE121.substring(i, i+15));
                    }
                }
            //}
        }
        if (im.hasField(112)){
            String rptaDE112 = im.getObjectValue(112).toString();
            if(!rptaDE112.equals(Constantes.EMPTY)){
                if(entrada.getTipoRecaudacion().equals(Constantes.TIPO_RECAUD_RIPLEY) ||
                   entrada.getTipoRecaudacion().equals(Constantes.TIPO_VENTA_RIPLEY)
                ){
                    if( entrada.getTipoTrnscc().equals(Constantes.TRNS_PAG_TARJ) ||
                        entrada.getTipoTrnscc().equals(Constantes.TRNS_CMPRA_VNTA) ||
                        entrada.getTipoTrnscc().equals(Constantes.TRNS_ANU_PAG) ){
                        parser112Ripley(rptaDE112);
                    }
                }
           }
        }
        if (im.hasField(125)){
            
        }*/
        return tabla;
    }
}
