package br.com.consultorio

class CheckController {
	
    def springSecurityService

    def index() {
        def roleNames = springSecurityService.principal.authorities*.authority		
        if (roleNames.contains("ROLE_DOCTOR")){
            redirect(controller: "atendimento", action: "index")
        } else {
            redirect(uri: "/")
        }
    }
}
