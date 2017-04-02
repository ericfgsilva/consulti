package br.com.consultorio.marshaller
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grails.converters.JSON
import br.com.consultorio.TipoConsulta
/**
 *
 * @author CelsoAgra
 */
class TipoConsultaJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(TipoConsulta) {
                def returnArray = [:]
				returnArray['id'] = it.id
                returnArray['tipo'] = it.nome
                return returnArray
        }
    }
}

