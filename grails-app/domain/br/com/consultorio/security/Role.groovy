package br.com.consultorio.security

class Role {

	String authority
	String roleCode

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
		roleCode blank: false, unique: true
	}
}
