package br.com.consulti.command

import br.com.consulti.exception.ValidationEntityException
import br.com.consulti.framework.constants.SituacaoConsulta
import br.com.consultorio.Consulta
import br.com.consultorio.Paciente
import br.com.consultorio.PlanoSaude
import br.com.consultorio.Prontuario
import br.com.consultorio.TipoConsulta
import br.com.consultorio.security.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.validation.Validateable

import java.text.SimpleDateFormat

/**
 * Created by celso on 6/6/15.
 */
@Validateable
class AgendarCommand {
    def springSecurityService

    String datahora
    User medico
    PlanoSaude plano
    Paciente paciente
    TipoConsulta tipoConsulta

    private Date getDatahoraDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = format.parse(datahora)
        return parsedDate
    }

    Consulta getConsulta(Map parameters = [:]) {
        Prontuario prontuario = Prontuario.findByMedicoAndPaciente(medico.username, paciente)
        Consulta consulta = new Consulta()
        consulta.dia = datahoraDate
        consulta.horaChegada = datahora.split(' ')[1]

        if (prontuario == null) {
            consulta.prontuario = new Prontuario(medico: medico.username, paciente: paciente)
        } else {
            consulta.prontuario = prontuario
        }

        consulta.planoSaude = plano
        consulta.tipoConsulta = tipoConsulta
        consulta.situacaoConsulta = SituacaoConsulta.MARCADO
        consulta.createdByUser = springSecurityService.currentUser.username
        consulta.lastUpdatedByUser = springSecurityService.currentUser.username

        if (parameters.failOnError) {
            consulta.validate()
            if (consulta.hasErrors()) {
                throw new ValidationEntityException()
            }
        }

        return consulta
    }
}
