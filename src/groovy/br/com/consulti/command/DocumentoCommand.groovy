package br.com.consulti.command

import br.com.consultorio.Consulta
import grails.validation.Validateable

/**
 * Created by celso on 8/1/15.
 */
@Validateable
class DocumentoCommand {
    String texto
    Consulta consulta
}
