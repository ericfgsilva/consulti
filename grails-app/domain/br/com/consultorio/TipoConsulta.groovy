package br.com.consultorio

/**
 *
 */
class TipoConsulta {

	String nome
	Date dateCreated
	Date lastUpdated

    static constraints = {
        nome (nullable: true, unique: true, size: 3..20)
    }
}
