package br.com.consultorio.services

import br.com.consulti.exception.ValidationEntityException
import br.com.consultorio.Consulta
import br.com.consultorio.Prontuario

/**
 *
 */
class ProntuarioService {

    /**
     *
     * @param consulta
     * @return
     */
    void addConsultaToProntuario(Consulta consulta) {
        Prontuario prontuario = consulta?.prontuario
        prontuario.addToConsultas(consulta)
        prontuario.save()

        if (prontuario.hasErrors() || consulta.hasErrors()) {
            throw new ValidationEntityException()
        }
    }
}
