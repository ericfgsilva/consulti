package br.com.consultorio

import br.com.consulti.exception.ConsultaDependencyException
import br.com.consulti.command.PacienteCommand
import br.com.consulti.exception.ValidationEntityException
import br.com.consulti.framework.constants.Controller
import br.com.consulti.framework.constants.MessageHandler
import br.com.consulti.framework.constants.Method
import br.com.consulti.framework.constants.RoleType
import br.com.consultorio.framework.ErrorHandlingController
import br.com.consultorio.security.Role
import br.com.consultorio.security.User
import br.com.consultorio.services.PacienteService
import grails.converters.JSON
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.BAD_REQUEST

/**
 * Controller responsável pela entidade Paciente
 */
class PacienteController extends ErrorHandlingController {

    // services
    PacienteService pacienteService
    def springSecurityService


    // Pages
    /**
     * Função para apresentar a tela de index
     */
    def index() {
		// TODO implement something
    }

    def prontuario(Paciente paciente) {
        respond paciente
    }

    def consultasProntuario (Paciente paciente) {
        User user = springSecurityService.getCurrentUser()
        List<Role> roles = (user.userRoles.toList())*.role
        Role roleAdmin  = roles.find { it.authority == RoleType.ROLE_ADMIN.name  }
        Role roleDoctor = roles.find { it.authority == RoleType.ROLE_DOCTOR.name }

        if (!roleAdmin && !roleDoctor) {
            throw new ValidationEntityException()
        }

        def criteria = Consulta.createCriteria()
        List consultas = []

        consultas = criteria.list {
            prontuario{
                eq('paciente', paciente)

                if (!roleAdmin && roleDoctor) {
                    eq('medico', user.username)
                }
            }
        }

        render consultas as JSON
    }

    /**
     * função para listar pacientes em um formato JSON
     * @return
     */
    def list() {
        render Paciente.list() as JSON
    }

    /**
     * Função para obter uma instancia de Paciente em um formato JSON
     * @param pacienteInstance
     * @return
     */
    def show(Paciente pacienteInstance) {
        render pacienteInstance as JSON
    }

    /**
     * Obtem uma instancia JSON de paciente para realizar o caso de edição
     * @param pacienteInstance
     * @return
     */
    def edit(Paciente pacienteInstance) {
        JSON.use('edit') {
            render pacienteInstance as JSON
        }
    }

    /**
     * Salva uma nova descrição para o paciente
     * @param pacienteCommand
     * @return
     */
    def salvarDescricao(PacienteCommand pacienteCommand) {
        pacienteService.saveDescricao(pacienteCommand)
        render message(code: MessageHandler.UPDATE_SUCCESS)
    }

    /**
     * obtém uma lista de planos de saúde para o paciente
     * @param pacienteInstance
     * @return
     */
    def planos(Paciente pacienteInstance) {

        List planos = PacientePlano.withCriteria {
            eq('paciente', pacienteInstance)
            projections{
                property('plano')
            }
        }

        render planos as JSON
    }

    /**
     *
     * @param pacienteInstance
     * @return
     */
    def save(PacienteCommand pacienteInstance) {
        Paciente paciente
        String mensagem = ''

        if (pacienteInstance == null) {
            notFound()
            return
        }

        if(pacienteInstance.id) {
            mensagem = message(code: MessageHandler.UPDATE_SUCCESS)
        } else {
            mensagem = message(code: MessageHandler.SAVE_SUCCESS)
        }
        paciente = pacienteService.saveOrUpdate(pacienteInstance);

        if (!paciente.hasErrors()) {
            render mensagem
        } else {
            render paciente.errors*.message, status: BAD_REQUEST
        }
        
    }

    /**
     *
     * @param paciente
     * @return
     */
    def planosAssociados(Paciente paciente){
        List<PlanoSaude> planos = PacientePlano.createCriteria.list{
            eq('paciente', paciente)
            projections {
                distinct('plano')
            }
        }
        
        render planos as JSON
    }

    /**
     *
     * @param paciente
     * @return
     */
    def planosDisponiveis(Paciente paciente){
        List<PlanoSaude> planos = PacientePlano.createCriteria.list{
            not { eq('paciente', paciente) }
            projections {
                distinct('plano')
            }
        }
        
        render planos as JSON
    }

    /**
     *
     * @return
     */
    def remove() {
        if (params.lista == null) {
            notFound()
            return
        }
        
        try {
            List idList = []

            if(params.lista instanceof List) {
                idList = params.lista
            } else {
                idList << params.lista
            }

            pacienteService.removeByList(idList)
            render message(code: MessageHandler.REMOVE_SUCCESS)
        } catch (ConsultaDependencyException e) {
            render message(code: MessageHandler.ERROR_PACIENTE_CONSULTARELACIONADA)
        }
    }

    /**
     *
     */
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = ''
                redirect action: Controller.ACTION_INDEX, method: Method.GET
            }
			'*'{ render status: NOT_FOUND }
        }
    }
}
