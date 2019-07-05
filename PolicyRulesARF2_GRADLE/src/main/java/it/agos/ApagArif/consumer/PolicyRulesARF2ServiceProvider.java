package it.agos.ApagArif.consumer;

import java.io.IOException;

import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.logging.Logger;

import it.agos.ApagArif.businessLogic.CheckError;
import it.agos.ApagArif.businessLogic.JsonConverter;
import it.agos.ApagArif.configurations.SingletonConfiguration;
import it.agos.ApagArif.producer.PolicyRulesARF2Service;
import it.agos.ApagArif.producer.PolicyRulesARF2ServiceInterface;

public class PolicyRulesARF2ServiceProvider implements PolicyRulesARF2ServiceInterface {

	@Override
	public Response invokeService(String authorization, String cod_istituto, String cod_programma_elab, String cod_user_lab, double cod_pratica, String cod_contesto) throws IOException {
		Logger logger = Logger.getLogger(PolicyRulesARF2ServiceProvider.class);
		logger.info("inizializzando il client request ...");
		SingletonConfiguration conf = SingletonConfiguration.getInstance();
		String URI= conf.getZconnUrl();
		
		ClientRequest request = new ClientRequest(URI);
		ClientResponse<String> response =null;
		JsonConverter jreq = new JsonConverter();
		String body = jreq.createRequest(cod_istituto, cod_programma_elab, cod_user_lab, cod_pratica, cod_contesto);
		request.accept("application/json").header("Authorization", authorization).body("application/json", body);
		CheckError error = new CheckError();
		try {
			if(authorization!=null && !authorization.equals("")) {
				logger.info("invio della request...");
				logger.info("in attesa della response dal backend ...");
				response = request.post(String.class);				
				if(response.getStatus()!=200) {
					return Response.status(response.getStatus()).entity(response.getEntity()).build();
				}
				String resp = response.getEntity().toString();
	
				JsonConverter jRespToClient = new JsonConverter();
				logger.info("conversione response in rest client compliant ...");
				resp = jRespToClient.JsonConversionUpToLow(resp, "NP0343BW_");
				logger.info("controllo errori e invio response verso client");
				return error.generaCodErrore(resp);
			}
			else {
				return Response.status(Response.Status.FORBIDDEN).entity("Header Mancante").build();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}

