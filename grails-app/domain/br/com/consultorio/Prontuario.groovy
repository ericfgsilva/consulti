package br.com.consultorio

import java.util.Date;

class Prontuario {

	Paciente paciente
	String medico
	boolean compartilhado

	/*
    informações do sistema
     */
	String lastUpdatedByUser
	String createdByUser
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [paciente : Paciente]
	static hasMany = [consultas : Consulta]
	
	static constraints = {
		paciente (nullable:false)
		compartilhado (nullable:false)
		lastUpdatedByUser (nullable:true)
		createdByUser (nullable:true)
	}
}
