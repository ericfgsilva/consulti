package br.com.consultorio

import br.com.consulti.framework.constants.SituacaoConsulta

/**
 * Classe responsável por representar a consulta médica
 * Cada consulta deve estar associada a um prontuário médico e deve conter uma lista de documentos
 * Os tipos de consultas podem ser: 1a Vez, ginecologia, 8o Mes, periodico
 * Além disso, as consultas podem ser preferencial, caso necessário
 * Podem vincular a consulta a um plano de saúde e ao número da cateira de registro do plano.
 * Caso não possua um plano de saúde, então deve ser caracterizado como uma consulta particular
 * Haverá cadastro do valor das consultas e se houve glosa (valorGlosa)
 */
class Consulta {

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

    /*
    informações do sistema
     */
    String lastUpdatedByUser
    String createdByUser
    Date dateCreated
    Date lastUpdated

    static belongsTo = [prontuario : Prontuario]
	static hasMany = [documentos:Documento]

    static constraints = {
        /*
        Obrigatórios
         */
        prontuario (nullable:false, blank: false)
        dia (nullable:false, blank: false)
        tipoConsulta (nullable:false)
        situacaoConsulta (nullable:false)

        /*
        Opicionais
         */
        ordemChegada (nullable:true)
        horaChegada (nullable:true, maxSize: 10)
        horaSaida (nullable:true, maxSize: 10)
        preferencial (nullable:true)
        planoSaude (nullable:true)
        numeroCarteira (nullable:true, size: 3..20)
        valor (nullable:true)
        valorGlosa (nullable:true)
        descricao (nullable:true)
        lastUpdatedByUser (nullable:true)
        createdByUser (nullable:true)
    }
}
