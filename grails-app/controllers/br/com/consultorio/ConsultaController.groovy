package br.com.consultorio

import br.com.consulti.command.AgendarCommand
import br.com.consulti.command.ConsultaCommand
import br.com.consulti.command.DocumentoCommand
import br.com.consulti.framework.constants.MessageHandler
import br.com.consulti.utils.DataHora
import br.com.consultorio.framework.ErrorHandlingController
import br.com.consultorio.services.ConsultaService
import br.com.consultorio.services.ProntuarioService
import grails.converters.JSON

class ConsultaController extends ErrorHandlingController {

	/*
	Service instances
	 */
	ConsultaService consultaService
	ProntuarioService prontuarioService
	
	/**
	 * Retorna uma lista de consultas de acordo com os parâmetros do sistema, a data e a situação da consulta
	 * @return
	 */
	def listByToday() {
		List appointments = consultaService.listByStatusAndDate(params?.situacaoConsulta ?: '', new Date(), params)
		render appointments as JSON
	}

	/**
	 * Lista informações da tela de Consulta - Filtro do auto complete da tela de wizard
	 * @param param
	 * @return
	 */
	def listPlanoSaudeAndUser(String param) {
		List parameters = consultaService.listPlanoSaudeAndUser(param)
		render parameters as JSON
	}

    /**
     *
     * @return
     */
    def list() {
		Date date = DataHora.getDateByString(params?.dia)
		List lista = consultaService.list(date)
        render lista as JSON
    }

	/**
	 *
	 * @return
	 */
	def listGroupedByProntuario() {
		Date date = DataHora.getDateByString(params?.dia)
		Map mapedList = consultaService.listGroupByProtuario(date)

		render mapedList as JSON
	}

    /**
     *
     * @param consulta
     * @return
     */
	def show(Consulta consulta) {
 		render consulta as JSON
	}

    /**
     *
     * @param consultaInstance
     * @return
     */
	def edit(Consulta consultaInstance) {
		respond consultaInstance
	}

	/**
	 *
	 * @param agendarCommand
	 * @return
	 */
    def agendar(AgendarCommand agendarCommand) {
		Consulta consulta = agendarCommand.getConsulta([failOnError: true])
		prontuarioService.addConsultaToProntuario(consulta)

		render message(code: MessageHandler.SAVE_SUCCESS)
    }

	/**
	 *
	 * @param consultaCommand
	 * @return
	 */
	def saveDescricao(ConsultaCommand consultaCommand) {
		consultaService.saveDescricaoConsulta(consultaCommand)
		render message(code: MessageHandler.SAVE_SUCCESS)
	}

	/**
	 *
	 * @param documento
	 * @return
	 */
	def savePrescricao(DocumentoCommand documentoCommand) {
		Documento documento = new Documento(consulta: documentoCommand.consulta, texto: documentoCommand.texto)
		TipoDocumento tipoDocumento = TipoDocumento.findByName(TipoDocumento.TYPE_PRESCRICAO)
		documento.tipoDocumento = tipoDocumento
		documento.save(flush: true, failOnError: true)
		render message(code: MessageHandler.PRESCRICAO_SAVE_SUCCESS)
	}

	/**
	 *
	 * @param documento
	 * @return
	 */
	def saveAtestado(DocumentoCommand documentoCommand) {
		Documento documento = new Documento(consulta: documentoCommand.consulta, texto: documentoCommand.texto)
		TipoDocumento tipoDocumento = TipoDocumento.findByName(TipoDocumento.TYPE_ATESTADO)
		documento.tipoDocumento = tipoDocumento
		documento.save(flush: true, failOnError: true)
		render message(code: MessageHandler.ATESTADO_SAVE_SUCCESS)

	}

	/**
	 *
	 * @param consulta
	 * @return
	 */
	def showDocumento(Documento documento) {
		render documento as JSON
	}
}
