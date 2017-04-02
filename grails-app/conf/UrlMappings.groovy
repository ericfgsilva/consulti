class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/rest/usuario/list" (controller: 'user', action: 'list', method: 'GET')
		"/rest/usuario/add" (controller: 'user', action: 'add', method: 'POST')
		"/rest/usuario/update" (controller: 'user', action: 'update', method: 'PUT')
		"/rest/usuario/remove/$id" (controller: 'user', action: 'removeUser', method: 'GET')
		"/rest/usuario/show/$id" (controller: 'user', action: 'show', method: 'GET')
		"/rest/usuario/reset/$id" (controller: 'user', action: 'resetPassword', method: 'GET')
		"/rest/usuario/userroles/$id" (controller: 'user', action: 'listUserRoles', method: 'GET')
		"/rest/usuario/managerole" (controller: 'user', action: 'manageRole', method: 'GET')
		
		"/rest/atendimento/compareceu/$id" (controller: 'consulta', action: 'compareceu', method: 'GET')
		"/rest/atendimento/consultasId" (controller: 'consulta', action: 'getConsultasIdByDate', method: 'GET')
		
        "/rest/consulta/list" (controller: 'consulta', action: 'list', method: 'GET')
		"/rest/consulta/add" (controller: 'consulta', action: 'add', method: 'POST')
		"/rest/consulta/update" (controller: 'consulta', action: 'update', method: 'POST')
		"/rest/consulta/atendido" (controller: 'consulta', action: 'atendido', method: 'POST')
		"/rest/consulta/cancel/$id" (controller: 'consulta', action: 'cancel', method: 'GET')
		"/rest/tipoconsulta/list" (controller: 'tipoConsulta', action: 'list', method: 'GET')
		"/rest/tipoconsulta/add" (controller: 'tipoConsulta', action: 'add', method: 'POST')
		"/rest/tipoconsulta/update" (controller: 'tipoConsulta', action: 'update', method: 'PUT')
		"/rest/tipoconsulta/remove/$id" (controller: 'tipoConsulta', action: 'remove', method: 'GET')
		"/rest/tipoconsulta/show/$id" (controller: 'tipoConsulta', action: 'show', method: 'GET')
		
		"/rest/paciente/remove/$id" (controller: 'paciente', action: 'remove', method: 'GET')
		"/rest/plano/list" (controller: 'planoSaude', action: 'list', method: 'GET')
		"/rest/plano/listByPaciente/$id" (controller: 'planoSaude', action: 'listByPaciente', method: 'GET')
		"/rest/plano/remove/$id" (controller: 'planoSaude', action: 'remove', method: 'GET')
		"/rest/paciente/linktoplano" (controller: 'paciente', action: 'linkToPlano', method: 'POST')
		"/rest/paciente/unlinktoplano" (controller: 'paciente', action: 'UnlinkToPlano', method: 'POST')
		
        "/"(view:"/index")
		"/monthly"(view:"/monthly")
        "500"(view:'/error')
        "/login"(view:'/login')
        
    }
        
    
}
