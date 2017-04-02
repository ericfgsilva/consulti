package br.com.consultorio.marshaller
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grails.converters.JSON
import br.com.consultorio.Consulta
import br.com.consultorio.TipoConsulta
/**
 *
 * @author CelsoAgra
 */
class ConsultaJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(Consulta) {
            def returnArray = [:]
            returnArray['id'] = it.id
            returnArray['dia'] = it?.dia?.format("dd/MM/yyyy")
            returnArray['ordemChegada'] = it.ordemChegada ?: ""
            returnArray['horaChegada'] = it.horaChegada
            returnArray['horaSaida'] = it.horaSaida
            returnArray['prontuario'] = it?.prontuario
            returnArray['numeroCarteira'] = it?.numeroCarteira
            returnArray['tipoConsulta'] = it.tipoConsulta
            returnArray['situacaoConsulta'] = it.situacaoConsulta?.toString() ?: ''
            returnArray['planoSaude'] = it.planoSaude
            returnArray['preferencial'] = (it.preferencial) ? "Sim" : "Nao"
            returnArray['valor'] = it?.valor
            returnArray['valorGlosa'] = it?.valorGlosa
            returnArray['descricao'] = it?.descricao
            returnArray['documentos'] = it?.documentos
            returnArray['createdByUser'] = it?.createdByUser
            return returnArray
        }
    }
}

