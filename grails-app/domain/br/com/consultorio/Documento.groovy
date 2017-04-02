package br.com.consultorio

/**
 *
 */
class Documento {
    String texto
	TipoDocumento tipoDocumento

    Date dateCreated
    Date lastUpdated
	
	static belongsTo = [consulta : Consulta]

    static constraints = {
		tipoDocumento (nullable:false, blank:false)
        texto (nullable:false, maxSize: 10000)
    }
}
