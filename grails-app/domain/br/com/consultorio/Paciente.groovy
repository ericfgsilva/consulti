package br.com.consultorio

class Paciente {

    String nome
    Date dataNascimento
    String telefone
    String cpf
    String rg
    String email
    String endereco
    String descricao

    /*
    informações do sistema
     */
    String lastUpdatedByUser
    String createdByUser
    Date dateCreated
    Date lastUpdated
	
    static hasMany = [planosSaude : PacientePlano, prontuarios : Prontuario]

    static constraints = {
        nome (nullable:false, size: 3..60)
        dataNascimento (nullable:false)
        telefone (nullable:false, maxSize: 60)
        rg (nullable:true, size: 3..20)
        cpf (nullable:true, size: 8..20)
        email (nullable:true, blank: true, /*email: true,*/ maxSize: 60)
        endereco (nullable:true, maxSize: 255)
        descricao (nullable:true, maxSize: 255)
        planosSaude(cascade: 'all-delete-orphan')
        lastUpdatedByUser (nullable:true)
        createdByUser (nullable:true)
    }
    static mapping = {
        sort "nome"
    }
}
