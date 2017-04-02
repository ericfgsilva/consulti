package br.com.consultorio.marshaller

import br.com.consultorio.Consulta
import br.com.consultorio.Paciente
import br.com.consultorio.Prontuario
import grails.converters.JSON

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class ProntuarioJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(Prontuario) {
            def returnArray = [:]
            returnArray['medico'] = it?.medico
            returnArray['paciente'] = it?.paciente
            returnArray['compartilhado'] = (it.compartilhado) ? "Sim" : "Nao"
            return returnArray
        }
    }
}

