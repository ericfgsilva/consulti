package br.com.consultorio.marshaller
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grails.converters.JSON
import br.com.consultorio.Paciente
import br.com.consultorio.PacientePlano;
/**
 *
 * @author CelsoAgra
 */
class PacientePlanoJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(PacientePlano) {
            def returnArray = [:]
            returnArray['id'] = it.id
			returnArray['paciente'] = it?.paciente
            returnArray['planoSaude'] = it?.planoSaude
            return returnArray
        }
    }
	
}

