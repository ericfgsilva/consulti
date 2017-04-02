package br.com.consultorio

/**
 *
 */
class TipoDocumento {

	static final String TYPE_ATESTADO = 'atestado'
	static final String TYPE_PRESCRICAO = 'atestado'

	String name
	String fullName
	Date dateCreated
	Date lastUpdated

    static constraints = {
        name (nullable: true, unique: true, size: 3..20)
		fullName (nullable: true, size: 3..20)
    }
}
