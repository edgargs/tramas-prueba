package com.gs.tramas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://spring.io/guides/gs/rest-service/
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	
	@Autowired
	Trama210Repository  repository;
	
	// http://localhost:8080/greeting?name=Edgar
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", defaultValue="World")String name) {
		return String.format(template, name);
	}
	
	@RequestMapping("/grabar")
	public String grabarTrama(@RequestParam(value="trama")String trama) {
		
		Trama210 respuesta;
		try {
			System.out.println(trama);
			respuesta = LectorBitmaps.cargarRespuesta(trama);
			repository.save(respuesta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "OK";
	}
	
	@RequestMapping("/generar")
	public String generarTrama(@RequestParam(value="monto")String monto, @RequestParam(value="numero")String numero) {
		EntradaBean entrada1 = new EntradaBean();
        
        entrada1.setMonto(monto); //"5.00");
        entrada1.setAuditoria(Constantes.TRACE.toString());
        entrada1.setTerminal("02548412");
        entrada1.setComercio("EL AGUSTINO-PRUEBA");
        entrada1.setUbicacion("AV. CESAR VALLEJO NRO. 1387 LIMA LIMA EL AGUSTINO");
        entrada1.setTelefono(numero); //"999999999");
        
        entrada1.setTipoMensaje(Constantes.MSG_200+"");
        entrada1.setTipoTrnscc(Constantes.TRNS_RECARGA);
        entrada1.setTipoCuentaFrom(Constantes.CTA_UNIVERSAL);
        entrada1.setTipoCuentaTo(Constantes.CTA_UNIVERSAL);
        
        entrada1.setTipoRecaudacion(Constantes.TIPO_RECAR_BITEL);
        
        Despachador despachador = new Despachador();
        System.out.println("Entrada"+entrada1);
        RespuestaBean respuesta;
        String resp;
		try {
			respuesta = despachador.enviar(entrada1);
			resp = respuesta.getTramaIn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp = "ACK";
		}
        
        return resp;
	}
	
}
