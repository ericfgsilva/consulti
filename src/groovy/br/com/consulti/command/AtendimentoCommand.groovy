package br.com.consulti.command

import br.com.consultorio.Consulta
import br.com.consultorio.Paciente
import grails.validation.Validateable

@Validateable
class AtendimentoCommand {
    Consulta consulta
    List<Consulta> consultas
    String medico
    Paciente paciente
}
