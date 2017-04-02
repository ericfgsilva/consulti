package br.com.consultorio

import java.io.Serializable;

/**
 *
 */
class PacientePlano implements Serializable {

    String numeroCarteira
    String via
    String dtValidadeInicio
    String dtValidadeFim
    String tipo
    String acomodacao
    Date dateCreated
	
    static belongsTo    = [planoSaude:PlanoSaude,paciente:Paciente]

    static constraints = {
        paciente (nullable:false, blank: false)
        planoSaude (nullable:false, blank: false)
        numeroCarteira (nullable:true, blank: true)
        via (nullable:true, blank: true)
        dtValidadeInicio (nullable:true, blank: true)
        dtValidadeFim (nullable:true, blank: true)
        tipo (nullable:true, blank: true)
        acomodacao (nullable:true, blank: true)
    }

}
