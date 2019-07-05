package it.agos.ApagArif.businessLogic;

public class CodeChanger {
	
	public String codeChangerLow (String smallCode) {
		String longCode="";
		longCode= smallCode.replace("cd_", "cod_");
		longCode= longCode.replace("gp_", "grp_");
		longCode= longCode.replace("nm_", "num_");
		longCode= longCode.replace("in_", "ind_");
		longCode= longCode.replace("tx_", "txt_");
		return longCode;
	}
	
	public String codeChangerUp (String longCode) {
		String smallCode="";
		smallCode= longCode.replace("GP_", "");
		smallCode= smallCode.replace("CD_", "COD_");
		smallCode= smallCode.replace("TX_", "TEXT_");
		smallCode= smallCode.replace("IN_", "IND_");
		smallCode= smallCode.replace("DN_", "NAME_");
		smallCode= smallCode.replace("DS_", "DESCRIPTION_");
		smallCode= smallCode.replace("NM_", "NUM_");
		smallCode= smallCode.replace("IN_", "IND_");
		return smallCode;
	}
	
}
