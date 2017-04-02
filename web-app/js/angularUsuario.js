// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('usuario');

// Iniciar módulo
var app = angular.module("usuario", ["config"]);

app.controller("UsuarioController", ['$http', 'configService', function($http, configService) {
        var instance = this;
        this.urlPath;
        this.usuarios = [];
        this.usuario = {};
        this.authorities = ["ROLE_USER", "ROLE_ADMIN", "ROLE_DOCTOR"];
        
        this.hasAuthority = function(authority, authorities) {
             var jsonAuthorities = JSON.parse(authorities);
             return jsonAuthorities.indexOf(authority) != -1;
        }
        
        this.getUsuarios = function() {
            $http.get(configService.path() + "/rest/usuario/list").success(function(json) {
                instance.usuarios = json;
            });
        }
        
        this.manageRole = function(role, id) {
        	$http.get(configService.path() + "/rest/usuario/managerole?role=" + role + "&id="+id).success(function(json) {
        		instance.getUsuarios();
            });
        }
        
        this.isRole = function(listRole, containsRole) {
        	var found = false;
        	for (index = 0; index < listRole.length; index++) {
        		if(listRole[index].role == containsRole) {
        			found = true;
        			break;
        		}
        	}
        	
        	if(found){
        		return "btn-primary";
        	} else {
        		return "btn-default";
        	}
        }
        
        this.getUserRoles = function() {
        	
        }
        
        this.addUsuario = function() {
        	$http.post(configService.path() + "/rest/usuario/add", instance.usuario).success(function(json) {
            	instance.getUsuarios();
            });
            console.log("adicionado!!");
        }

        this.resetPassword = function(id) {
        	console.log("resetando senha de: " + id);
        	console.log(configService.path() + "/rest/usuario/reset/" + id);
        	
        	if(!confirm('Tem certeza que deseja alterar a senha deste usuário?')){
        		return false;
        	}
        	
            $http.get(configService.path() + "/rest/usuario/reset/" + id).success(function(json) {
            	instance.getUsuarios();
            });
        }
        
        this.removeUsuario = function(id) { 
        	if(!confirm('Tem certeza que deseja remover este usuário?')){
        		return false;
        	}
        	$http.get(configService.path() + "/rest/usuario/remove/" + id).success(function(json) {
            	instance.getUsuarios();
            });
        }
        
        this.addAuthority = function(authority, username) {
            console.log("Adicionando " + authority + " de " + username);
            $http.get(configService.path() + "/sis/rest/usuario/addAuthority?authority=" + authority + "&username=" + username).success(function(data) {
                instance.listUsuario();
            });
            
        }
        
        this.removeAuthority = function(authority, username) {
            console.log("Removendo " + authority + " de " + username);
            $http.get(configService.path() + "/sis/rest/usuario/removeAuthority?authority=" + authority + "&username=" + username).success(function(data) {
                instance.listUsuario();
            });            
        }
    }]);