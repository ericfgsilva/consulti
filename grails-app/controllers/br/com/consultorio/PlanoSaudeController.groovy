package br.com.consultorio

import grails.converters.JSON
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

/**
 * 
 */
class PlanoSaudeController {

    /**
     * 
     */
    def index() {
    }

    /**
     * 
     */
    def list() {
        render PlanoSaude.list(sort: "nome", order: "asc") as JSON
    }

    /**
     * 
     */    
    def show(PlanoSaude planoSaudeInstance) {
        JSON result

        if(planoSaudeInstance) {
            result = planoSaudeInstance as JSON
        }

        response.status = OK.value
        render result
    }

    def listByPaciente(Paciente pacienteInstance) {
        def criteria = PacientePlano.createCriteria()
        def planosList = criteria.list {
            eq("paciente", pacienteInstance)
            projections { property("planoSaude") }
        }
        planosList << new PlanoSaude(nome: 'Consulta Particular')

        render planosList as JSON
    }

    @Transactional
    def save(PlanoSaude planoSaudeInstance) {
        if (planoSaudeInstance == null) {
            notFound()
            return
        }

        if (!planoSaudeInstance.hasErrors()) {
            planoSaudeInstance.save flush:true
        }
		
        render "cadastrado com sucesso"
    }

    @Transactional
    def update(PlanoSaude planoSaudeInstance) {
        if (planoSaudeInstance == null) {
            notFound()
            return
        }

        if (!planoSaudeInstance.hasErrors()) {
            planoSaudeInstance.save flush:true
        }
        
        render "alterado com sucesso"
    }

    @Transactional
    def remove() {
        if (params.lista == null) {
            notFound()
            return
        }
        
        try{
            List idList = params.lista			

            List planos = PlanoSaude.findAllByIdInList(idList)
		    
            boolean found = false

            for(planoSaude in planos) {
                if (existsFK(planoSaude)){
                  render status: 500, "O plano de saúde '" + planoSaude.nome + "' está vinculado a um(a) paciente."  
                  found = true
                  break
                }else{
                    planoSaude.delete(flush:true)
                }
            }
            
            if (!found){
                render "Os planos foream removidos com sucesso!"
            }

        }catch(ClassCastException e){
            PlanoSaude plano = PlanoSaude.findById(params.lista)
			
            if(existsFK(plano)){
                render status: 500, "O plano de saúde '" + plano.nome + "' está vinculado a um(a) paciente."
            }else{
                plano.delete(flush:true)
                render "Plano removido com sucesso!"
            }
        }
    }

    private boolean existsFK(PlanoSaude plano){
        List paciente = PacientePlano.findAllByPlanoSaude(plano)
        return paciente.size > 0 ? true : false 
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [
                        message(code: 'planoSaude.label', default: 'PlanoSaude'),
                        params.id
                    ])
                redirect action: "index", method: "GET"
            }
			'*'{ render status: NOT_FOUND }
        }
    }
}
