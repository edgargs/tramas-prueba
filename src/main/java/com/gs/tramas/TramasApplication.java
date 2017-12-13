package com.gs.tramas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TramasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TramasApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(Trama210Repository repository) {
		return (args) -> {
			// save a couple of customers
			//repository.save(new Trama210("Jack"));
			
			//String trama = "0210F27880010A808000000000000000001F1622222200000000000000000000000005000920105916000000001112221059160920092006500010111222      140254841204900000000000002hanv       999";
			                //0210F27880010A808000000000000000001F1622222200000000000000000000000005000920105916000000001112221059160920092006500010111222 140254841204900000000000002hanv 999
			//LectorBitmaps.verTrama(trama);
			
			//Trama210 respuesta = LectorBitmaps.cargarRespuesta(trama);
			//repository.save(respuesta);
			
			// curl -d "trama=0210F27880010A808000000000000000001F1622222200000000000000000000000005000920105916000000001112221059160920092006500010111222      140254841204900000000000002hanv       999" http://localhost:8080/grabarTrama
			
			/*EntradaBean entrada1 = new EntradaBean();
	        
	        entrada1.setMonto("5.00");
	        entrada1.setAuditoria(Constantes.TRACE.toString());
	        entrada1.setTerminal("02548412");
	        entrada1.setComercio("EL AGUSTINO-PRUEBA");
	        entrada1.setUbicacion("AV. CESAR VALLEJO NRO. 1387 LIMA LIMA EL AGUSTINO");
	        entrada1.setTelefono("999999999");
	        
	        entrada1.setTipoMensaje(Constantes.MSG_200+"");
	        entrada1.setTipoTrnscc(Constantes.TRNS_RECARGA);
	        entrada1.setTipoCuentaFrom(Constantes.CTA_UNIVERSAL);
	        entrada1.setTipoCuentaTo(Constantes.CTA_UNIVERSAL);
	        
	        entrada1.setTipoRecaudacion(Constantes.TIPO_RECAR_BITEL);
	        
	        Despachador despachador = new Despachador();
	        System.out.println("Entrada"+entrada1);
	        RespuestaBean respuesta = despachador.enviar(entrada1);
	        
	        System.out.println(respuesta.getTramaIn());*/
			
			// http://localhost:8080/generar?monto=5.00&numero=9999999
	        
		};
	}
}
