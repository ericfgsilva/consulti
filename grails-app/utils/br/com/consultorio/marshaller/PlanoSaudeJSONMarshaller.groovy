package br.com.consultorio.marshaller
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grails.converters.JSON
import br.com.consultorio.Paciente
import br.com.consultorio.PlanoSaude;
/**
 *
 * @author CelsoAgra
 */
class PlanoSaudeJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(PlanoSaude) {
            def returnArray = [:]
            returnArray['id'] = it.id
            returnArray['nome'] = it.nome
            returnArray['descricao'] = it.descricao ?: ''
            returnArray['registroANS'] = it.registroANS ?: ''
            returnArray['contato'] = it.contato ?: ''
            return returnArray
        }
    }
	
}

