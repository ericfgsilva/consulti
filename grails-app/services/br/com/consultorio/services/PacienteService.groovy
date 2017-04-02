package br.com.consultorio.services

import br.com.consulti.exception.ConsultaDependencyException
import br.com.consultorio.Consulta
import br.com.consultorio.Paciente
import br.com.consulti.command.PacienteCommand

class PacienteService {

    /**
     *
     * @param pacienteInstance
     * @return
     */
    def saveOrUpdate(PacienteCommand pacienteInstance) {
        Paciente paciente = pacienteInstance.paciente
        paciente.save()
        return paciente
    }

    def removeByList(List idList) {
        List<Paciente> pacientes = Paciente.findAllByIdInList(idList)

        pacientes.each { Paciente paciente ->
            Integer totalConsultas = Consulta.countByPaciente(paciente)

            if(totalConsultas > 0) {
                throw new ConsultaDependencyException()
            }

            removeAllPlanos(new PacienteCommand(id: paciente.id))
            paciente.delete()
        }


    }

    /**
     *
     * @param pacienteInstance
     * @return
     */
    def saveDescricao(PacienteCommand pacienteInstance) {
        Paciente paciente = pacienteInstance.getPacienteById()
        paciente.descricao = pacienteInstance.descricao
        paciente.save()
    }
}
