package br.com.consultorio.mock

import com.br.consultorio.constantes.ConstantesUsuario;

import grails.transaction.Transactional
import grails.util.Environment;
import br.com.consultorio.InformacoesUsuario
import br.com.consultorio.mock.impl.RegisterMockImpl
import br.com.consultorio.security.Role
import br.com.consultorio.security.User
import br.com.consultorio.security.UserRole

class MockUser implements RegisterMockImpl {

	def mock() {
		def celso
		def paula
		def secretaria
		
		if(User.count() == 0) {
			def admin = new Role(authority: 'ROLE_ADMIN', roleCode: ConstantesUsuario.ROLE_ID_ADMIN).save flush:true
			def doctor = new Role(authority: 'ROLE_DOCTOR', roleCode: ConstantesUsuario.ROLE_ID_MEDICO).save flush:true
			def user = new Role(authority: 'ROLE_USER', roleCode: ConstantesUsuario.ROLE_ID_USER).save flush:true
		
		
			if (Environment.current == Environment.PRODUCTION) {
				celso = new User(username: "admin", password: "c0nsult1").save flush:true
				paula = new User(username: "paula", password: "p@u1@").save flush:true
				secretaria = new User(username: "secretaria", password: "s3cr3t@r1@").save flush:true
			} else {
				celso = new User(username: "admin", password: "admin").save flush:true
				paula = new User(username: "paula", password: "paula").save flush:true
				secretaria = new User(username: "secretaria", password: "secretaria").save flush:true
			}
			
			
			UserRole.create celso, admin, true
			UserRole.create paula, doctor, true
			UserRole.create secretaria, user, true
		}
	}
}
