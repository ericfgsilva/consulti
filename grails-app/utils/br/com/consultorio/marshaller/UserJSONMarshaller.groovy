package br.com.consultorio.marshaller
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grails.converters.JSON
import br.com.consultorio.security.User
/**
 *
 * @author CelsoAgra
 */
class UserJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(User) {
                def returnArray = [:]
				returnArray['id'] = it.id
				returnArray['username'] = it.username
				returnArray['userRoles'] = it.userRoles
                return returnArray
        }
    }
}

