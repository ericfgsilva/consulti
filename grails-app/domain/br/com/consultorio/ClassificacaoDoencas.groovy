package br.com.consultorio

class ClassificacaoDoencas {

    String nome
	String codigo
	String descricao
	Date dateCreated
    Date lastUpdated
	
    static hasMany = [planosSaude:PacientePlano]

    static constraints = {
        nome (nullable:false, size: 3..60)
		codigo (nullable:false, size: 3..60)
        descricao (nullable:true, maxSize: 255)
    }
}
