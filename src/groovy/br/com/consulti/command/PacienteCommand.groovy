package br.com.consulti.command

import br.com.consulti.utils.DataHora
import br.com.consultorio.Paciente
import br.com.consultorio.PacientePlano
import br.com.consultorio.Prontuario
import grails.validation.Validateable

/**
 *
 */
class PacienteCommand {
    Long id
    String nome
    String dataNascimento
    String telefone
    String cpf
    String rg
    String email
    String endereco
    String descricao
    Date dateCreated
    Date lastUpdated
    List<PacientePlanoCommand> planosSaude = []
    List<Prontuario> prontuarios = []

    /**
     *
     * @return
     */
    Paciente getPacienteById() {

        if (this?.id == null) {
            // TODO throw exception
        }

        Paciente paciente = Paciente.findById(this.id)

        if (paciente == null) {
            // TODO throw exception
        }

        return paciente
    }

    /**
     *
     * @return
     */
    Paciente getPaciente() {
        Paciente paciente = null

        this.with {
            if(id) {
                paciente = Paciente.findById(id)
            }

            if (!paciente) {
                paciente = new Paciente()
            }

            paciente.nome = nome
            paciente.dataNascimento = DataHora.getDateByString("yyyy-MM-dd", dataNascimento)
            paciente.telefone = telefone
            paciente.cpf = cpf
            paciente.rg = rg
            paciente.email = email
            paciente.endereco = endereco
            paciente.descricao = descricao
            paciente.planosSaude?.clear()

            planosSaude?.each { PacientePlanoCommand pacientePlano ->
                pacientePlano.pacienteId = paciente?.id
                paciente.addToPlanosSaude(pacientePlano.pacientePlano)
            }

            // TODO List<Prontuario> prontuarios
            return paciente
        }
    }
}
