package br.com.consultorio

import br.com.consultorio.formularios.FormularioCadUser
import br.com.consultorio.security.Role
import br.com.consultorio.security.User

class InformacoesUsuario {

	String nome
	String sobrenome
	String cbo
	String nuConsReg
	String nuCpf
	String email
	String dtNascimento
	String endereco
	String complemento
	String perfil
	String cep
	String telefone
	String celular
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [user:User]
	
	static constraints = {
		nome (nullable:false, size: 3..60)
		sobrenome(nullable:false, size: 3..60)
		cbo (nullable:false)
		perfil (nullable:false)
		nuConsReg (nullable:false)
		dtNascimento (nullable:false)
		telefone (nullable:false, maxSize: 20)
		celular (nullable:false, maxSize: 20)
		nuCpf (nullable:false, size: 8..20)
		email (nullable:false, blank: true, /*email: true,*/ maxSize: 60)
		endereco (nullable:false, maxSize: 255)
		cep (nullable: false)
		complemento (nullable:true, maxSize: 255)
		user (nullable: true)
	}
	
	static mapping = {
		sort "nome"
	}
	
	static salvar(FormularioCadUser form, Role role, User user){
		InformacoesUsuario info = new InformacoesUsuario(nome: form.nome, sobrenome: form.sobrenome, cbo: form.cbo, nuConsReg: form.nuConsReg,
			nuCpf: form.nuCpf, email: form.email, dtNascimento: form.dtNascimento, endereco: form.endereco,
			complemento: form.complemento, perfil: role.id, cep: form.cep,
			telefone: form.telefone, celular: form.celular, user: user).save(flush: true)
	}
}
