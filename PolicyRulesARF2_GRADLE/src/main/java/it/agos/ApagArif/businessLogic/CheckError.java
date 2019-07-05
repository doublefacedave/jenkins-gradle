package it.agos.ApagArif.businessLogic;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Status;
import org.jboss.resteasy.client.ClientResponse;
import org.json.JSONObject;

import javax.ws.rs.core.Response.*;

import javax.wsdl.Output;

public class CheckError {




	public Response generaCodErrore(String resp) {
		
		JSONObject jresp = new JSONObject(resp);
		String codErr = jresp.getJSONObject("Z137-esitointerrogazionepolicyrules-v01-agoperationresponse").getJSONObject("contoue").getJSONObject("dati_output_e").getJSONObject("esito_elab_e").get("cod_esitoe_elab").toString();
		if (codErr.contains("w") || codErr.contains("e") || codErr.contains("a")){
			String firstMessage, secondMessage;
			firstMessage = jresp.getJSONObject("Z137-esitointerrogazionepolicyrules-v01-agoperationresponse").getJSONObject("contoue").getJSONObject("dati_output_e").getJSONObject("esito_elab_e").get("text_esie_err_01").toString();
			secondMessage = jresp.getJSONObject("Z137-esitointerrogazionepolicyrules-v01-agoperationresponse").getJSONObject("contoue").getJSONObject("dati_output_e").getJSONObject("esito_elab_e").get("text_esie_err_02").toString();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(firstMessage + " " + secondMessage).build();
		}
		else if(codErr.contains(" ")){
			return Response.ok(resp, MediaType.APPLICATION_JSON).build();
		}
		else {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Codice Esito non riconosciuto").build();
		}
	}
}
