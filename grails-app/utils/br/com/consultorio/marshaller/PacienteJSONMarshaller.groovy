package br.com.consultorio.marshaller
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grails.converters.JSON
import br.com.consultorio.Paciente
import br.com.consultorio.PacientePlano

/**
 *
 */
class PacienteJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(Paciente) {
            def returnArray = [:]
            returnArray['id'] = it.id
            returnArray['nome'] = it.nome
            returnArray['dataNascimento'] = it.dataNascimento?.format("yyyy-MM-dd")
            returnArray['rg'] = it.rg
            returnArray['cpf'] = it.cpf
            returnArray['telefone'] = it.telefone
            returnArray['email'] = it.email
            returnArray['endereco'] = it.endereco
            returnArray['descricao'] = it.descricao
			returnArray['planosSaude'] = it.planosSaude
            return returnArray
        }
        
        JSON.createNamedConfig('edit') {
            it.registerObjectMarshaller(PacientePlano) {
                def returnArray = [:]
                returnArray['planoSaude'] = it.planoSaude.id
                returnArray['nome'] = it.planoSaude.nome
                returnArray['numeroCarteira'] = it.numeroCarteira
                returnArray['tipo'] = it.tipo
                returnArray['via'] = it.via
                returnArray['acomodacao'] = it.acomodacao
                returnArray['dtValidadeInicio'] = it.dtValidadeInicio
                returnArray['dtValidadeFim'] = it.dtValidadeFim
                return returnArray
            }
            
            it.registerObjectMarshaller(Paciente) {
                def returnArray = [:]
                returnArray['id'] = it.id
                returnArray['nome'] = it.nome
                returnArray['dataNascimento'] = it.dataNascimento?.format("yyyy-MM-dd")
                returnArray['rg'] = it.rg
                returnArray['cpf'] = it.cpf
                returnArray['telefone'] = it.telefone
                returnArray['email'] = it.email
                returnArray['endereco'] = it.endereco
                returnArray['descricao'] = it.descricao
                returnArray['planosSaude'] = it.planosSaude
                return returnArray
            }
        }
    }
	
}

