package br.com.consultorio.model

class JSONProntuario {

	String medico
	String descricao
	String tipoAtendimento
	String data
	
	void setData(Date data){
		def tz = TimeZone.getTimeZone('GMT')
		this.data = data.format("dd/MM/yyyy", tz);
	}
}
