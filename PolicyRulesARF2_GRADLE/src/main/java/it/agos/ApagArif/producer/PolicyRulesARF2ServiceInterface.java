package it.agos.ApagArif.producer;

import java.io.IOException;

import javax.ws.rs.core.Response;

public interface PolicyRulesARF2ServiceInterface {
	
	public Response invokeService(String authorization, String cod_istituto, String cod_programma_elab, String cod_user_lab, double cod_pratica, String cod_contesto) throws IOException;
	
}
