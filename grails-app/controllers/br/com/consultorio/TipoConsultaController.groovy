package br.com.consultorio

import grails.converters.JSON

class TipoConsultaController {

    def index() {
	}
	
	def list() {
        render TipoConsulta.list() as JSON
    }
	
	def add(TipoConsulta tipoConsulta) {
    	tipoConsulta.save(flush:true)
		response.status = 200
		render "CREATED"
    }
	
	def remove() {
        TipoConsulta tipo = TipoConsulta.findById(params?.id)
		tipo.delete(flush: true)
		response.status = 200
		render "DELETED"
    }
	
	def show() {
        TipoConsulta tipo = TipoConsulta.findById(params?.id)
		render tipo as JSON
    }
	
	def update(TipoConsulta tipoConsulta) {
		tipoConsulta.save(flush:true)
		response.status = 200
		render "UPDATED"
    }
}
