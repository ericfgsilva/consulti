package br.com.consultorio.formularios

import grails.validation.Validateable
import br.com.consultorio.security.User

@Validateable
class FormularioCadUser {

	public String nome
	public String sobrenome
	public String cbo
	public String nuConsReg
	public String nuCpf
	public String email
	public String dtNascimento
	public String endereco
	public String complemento
	public String perfil
	public String cep
	public String telefone
	public String celular
	public String username
	public String password
	public String confirmPwd
	
	public boolean isFormValid(){
		if (isCampoFormNulo() || !isPwdEqual() || isUsernameExists()){
			return false
		}
		
		return true
	}
	
	private boolean isPwdEqual(){
		if (password.equals(confirmPwd)){
				return true
		}
		
		return false
	}
	
	private boolean isUsernameExists(){
		User user = User.findByUsername(username)
		
		if (user == null){
			return false
		}

		return true
	}
	
	private boolean isCampoFormNulo(){
		return (nome == null || sobrenome == null || cbo == null || nuConsReg == null 
			|| nuCpf == null || email == null || dtNascimento == null || endereco == null
			|| complemento == null || perfil == null || cep == null || telefone == null || celular == null
			|| username == null || password == null || confirmPwd == null) ? true : false
	}
}
