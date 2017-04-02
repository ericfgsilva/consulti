package br.com.consultorio

class PlanoSaude {

    String nome
    String descricao
    String registroANS
    String contato
    /*
    informações do sistema
     */
    String lastUpdatedByUser
    String createdByUser
    Date dateCreated
    Date lastUpdated

    static constraints = {
        nome (nullable:false, size: 3..60)
        descricao (nullable:true, maxSize: 255)
        registroANS (nullable:true, size: 3..20)
        contato (nullable:true, maxSize: 60)
        lastUpdatedByUser (nullable:true)
        createdByUser (nullable:true)
    }
}
