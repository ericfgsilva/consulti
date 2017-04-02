package br.com.consultorio

import grails.transaction.Transactional
import br.com.consultorio.formularios.FormularioCadUser
import br.com.consultorio.security.Role;
import br.com.consultorio.security.User
import br.com.consultorio.security.UserRole;

class SecretariaController {

    def index() {
		
	}
	
	@Transactional
	def save (FormularioCadUser form){
		
		if (form.isFormValid()){
			User usuario = new User(username: form.username, password: form.password)
			User.salvar(usuario)
			
			Role role = Role.findByRoleCode(form.perfil)
			UserRole.create(usuario, role, true)
			
			InformacoesUsuario.salvar(form, role, usuario)
		}else{
			return
		}
		
	}
}
