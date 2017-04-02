package br.com.consulti.command

import br.com.consulti.utils.DataHora
import br.com.consultorio.Paciente
import br.com.consultorio.PacientePlano
import br.com.consultorio.PlanoSaude
import grails.validation.Validateable

@Validateable
class PacientePlanoCommand {
    Long id
    Long pacienteId
    String nome
    String dtValidadeInicio
    String dtValidadeFim
    String numeroCarteira
    String tipo
    String via
    String acomodacao

    PacientePlano getPacientePlano() {
        PacientePlano pacientePlano = null
        PlanoSaude planoSaude = null
        Paciente paciente = null

        this.with {
            if(id) {
                planoSaude = PlanoSaude.findById(id)
            }

            if (pacienteId) {
                paciente = Paciente.findById(pacienteId)
            }

            if (paciente && planoSaude) {
                pacientePlano = PacientePlano.findByPlanoSaudeAndPaciente(planoSaude, paciente)
            }

            if (!pacientePlano) {
                pacientePlano = new PacientePlano()
                pacientePlano.paciente = paciente
                pacientePlano.planoSaude = planoSaude
            }

            pacientePlano.numeroCarteira = numeroCarteira
            pacientePlano.via = via
            pacientePlano.dtValidadeInicio = DataHora.getDateByString("yyyy-MM-dd", dtValidadeInicio)
            pacientePlano.dtValidadeFim = DataHora.getDateByString("yyyy-MM-dd", dtValidadeFim)
            pacientePlano.tipo = tipo
            pacientePlano.acomodacao = acomodacao
        }

        return pacientePlano
    }
}

