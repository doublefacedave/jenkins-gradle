package it.agos.ApagArif.businessLogic;

import it.agos.ApagArif.businessLogic.CodeChanger;

public class JsonConverter {
	private String output = "";
	
	public String JsonConversionUpToLow(String input, String stringToTrim) {
		CodeChanger codeChanger = new CodeChanger();
		output= input.replace(stringToTrim, "");
		output= output.replace("NP0343BT-", "");
		output= output.replace("NP0343BT", "");
		output= codeChanger.codeChangerUp(output);
		output= output.toLowerCase();
		output= output.replace("z137", "Z137");
		return output;
	}
	
	public String createRequest(String cod_istituto, String cod_programma_elab, String cod_user_lab, double cod_pratica, String cod_contesto) {
		String jsonRequest="{\r\n" + 
				"    \"Z137-NP0343BT-EsitoInterrogazionePolicyRules-V01-AGOperation\" : \r\n" + 
				"	{\r\n" + 
				"        \"NP0343BT-METODO\" :{\r\n" + 
				"            \"NP0343BW_GP_DATI_METODO\" :{\r\n" + 
				"                \"NP0343BW_CD_ISTITUTO\" : \""+ cod_istituto + "\",\r\n" + 
				"                \"NP0343BW_CD_PROGRAMMA_ELAB\" :\"" + cod_programma_elab + "\",\r\n" + 
				"                \"NP0343BW_CD_USER_ELAB\" : \"" + cod_user_lab + "\"\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"NP0343BTCONTINP\" : {\r\n" + 
				"            \"NP0343BW_GP_DATI_INPUT\" : {\r\n" + 
				"                \"NP0343BW_CD_PRATICA\" :\"" + cod_pratica + "\",\r\n" + 
				"                \"NP0343BW_CD_CONTESTO\" :\"" + cod_contesto + "\"\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
		
		
		return jsonRequest;
	}
}
