package br.com.consulti.command

import br.com.consulti.framework.constants.SituacaoConsulta
import br.com.consultorio.PlanoSaude
import br.com.consultorio.TipoConsulta
import grails.validation.Validateable

@Validateable
class ConsultaCommand {
    Long id
    Date dia
    Integer ordemChegada
    String horaChegada
    String horaSaida
    TipoConsulta tipoConsulta
    SituacaoConsulta situacaoConsulta
    boolean preferencial
    PlanoSaude planoSaude
    String numeroCarteira
    Double valor
    Double valorGlosa
    String descricao
}
