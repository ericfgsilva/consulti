package br.com.consultorio

import br.com.consulti.command.AtendimentoCommand
import br.com.consulti.command.ConsultaCommand
import br.com.consulti.framework.constants.RoleType
import br.com.consulti.framework.constants.SituacaoConsulta
import br.com.consultorio.security.Role
import br.com.consultorio.security.User
import br.com.consultorio.services.ConsultaService
import grails.converters.JSON

class AtendimentoController {

    /*
    Service instances
     */
    ConsultaService consultaService
    def springSecurityService

    /**
     * Tela principal, de index
     */
    def index() {
		
	}

    /**
     * Retorna a quantidade de consultas de acordo com os par�metros do sistema, em especial, a data e a situa��o da consulta
     * @return
     */
    def mostrarContadores() {
        Integer marcado = consultaService.countBySituacaoConsulta(SituacaoConsulta.MARCADO, new Date().clearTime())
        Integer consultado = consultaService.countBySituacaoConsulta(SituacaoConsulta.CONSULTADO, new Date().clearTime())
        render ([agendados : marcado, consultados : consultado] as JSON)
    }

    /**
     * Alterar o status de uma consulta médica para 'ANDAMENTO'. Isso caracteriza que o paciente está em atendimento.
     * Pode até ser utilizado para guardar a situação atual de um paciente
     * @param consulta
     * @return
     */
    def iniciarConsulta(ConsultaCommand consultaCommand) {
        consultaService.verificarSituacaoConsulta(consultaCommand, SituacaoConsulta.MARCADO)
        consultaService.resetConsultasEmAtendimento()
        consultaService.setSituacaoConsulta(consultaCommand, SituacaoConsulta.ANDAMENTO)

        AtendimentoCommand atendimento = consultaService.getConsultaByAtendimento(consultaCommand)
        render atendimento as JSON
    }

    /**
     *
     * @param consultaCommand
     * @return
     */
    def finalizarConsulta(ConsultaCommand consultaCommand) {
        consultaService.verificarSituacaoConsulta(consultaCommand, SituacaoConsulta.ANDAMENTO)
        consultaService.setSituacaoConsulta(consultaCommand, SituacaoConsulta.CONSULTADO)
        render ( [msg : 'consulta realizada com sucesso!'] as JSON )
    }

    /**
     *
     * @return
     */
    def consultasMarcadasDoDia() {
        User user = springSecurityService.getCurrentUser()
        List<Role> roles = (user.userRoles.toList())*.role
        Role roleAdmin  = roles.find { it.authority == RoleType.ROLE_ADMIN.name  }

        if(roleAdmin) {
            user = null
        }

        List<Consulta> consultas = consultaService.listConsultas(SituacaoConsulta.MARCADO, new Date().clearTime(), user)
        render consultas as JSON
    }

    /**
     *
     * @param consultaCommand
     * @return
     */
    def refreshProntuario(ConsultaCommand consultaCommand) {
        List<Consulta> consultas = consultaService.getConsultaByAtendimento(consultaCommand).consultas
        render consultas as JSON
    }
}
