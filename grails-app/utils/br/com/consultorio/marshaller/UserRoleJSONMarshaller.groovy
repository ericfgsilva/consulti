package br.com.consultorio.marshaller
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import grails.converters.JSON
import br.com.consultorio.security.User
import br.com.consultorio.security.UserRole;
/**
 *
 * @author CelsoAgra
 */
class UserRoleJSONMarshaller {
    
    def register(){
        JSON.registerObjectMarshaller(UserRole) {
                def returnArray = [:]
                returnArray['user'] = it.user.id
				returnArray['role'] = it.role.authority
                return returnArray
        }
    }
}

