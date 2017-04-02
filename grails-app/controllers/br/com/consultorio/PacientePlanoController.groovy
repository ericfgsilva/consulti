package br.com.consultorio

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON;
import grails.transaction.Transactional

class PacientePlanoController {
	/**
	 *
	 */
	def index() {
	}

	/**
	 *
	 */
	def list() {
		render PacientePlano.list(sort: "paciente.nome", order: "asc") as JSON
	}
	
	@Transactional
    def remove() {
        if (params.lista == null) {
            notFound()
            return
        }
        
		try{
			List idList = params.lista
			
			List<PacientePlano> planos = PacientePlano.findAllByIdInList(idList)
			
			planos.each { PacientePlano plano ->
				plano.delete flush:true
			}
		}catch(ClassCastException e){
			PacientePlano plano = PacientePlano.findById(params.lista)
			
			plano.delete(flush:true)
		}
        
        render PacientePlano.list(sort: "paciente.nome", order: "asc") as JSON
    }
	
	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [
						message(code: 'paciente.label', default: 'PacientePlano'),
						params.id
					])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
