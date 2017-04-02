package br.com.consultorio

import br.com.consultorio.model.UserForm
import br.com.consultorio.security.Role
import br.com.consultorio.security.User
import br.com.consultorio.security.UserRole
import grails.converters.JSON

import static org.springframework.http.HttpStatus.*

class UserController {
	def springSecurityService

    def index() {
    }
	
	def list() {
		render User.list() as JSON
	}

	def listMedics(){
		Role role = Role.findByAuthority("ROLE_DOCTOR")

		def criteria = UserRole.createCriteria()
		def userList = criteria.list {
			eq("role", role)
			projections {property("user")}
		}

		render userList as JSON
	}

	def listUserRoles(User userInstance) {
		List userRoles = UserRole.withCriteria{
			eq("id", userInstance.id)
		}
		
		render userRoles as JSON
	}
	
	def add(UserForm userFormInstance) {
		User userInstance = new User(username: userFormInstance.username, password: 'mude', enabled: true)
		userInstance.validate()
		
		if(userInstance.hasErrors()){
			render "NOT CREATED", status: BAD_REQUEST
		} else {
			userInstance.save(flush:true)
			render "CREATED", status: CREATED
		}
	}
	
	def remove() {
		User tipo = User.findById(params?.id)
		tipo.delete(flush: true)
		render "DELETED", status: OK
	}
	
	def show(User user) {
		render user as JSON
	}
	
	def ManageRole() {
		Role role = Role.findByAuthority(params.role)
		User user = User.findById(params.id)
		UserRole userRole = UserRole.findByUserAndRole(user, role)
		
		if(userRole == null) {
			UserRole.create user, role, true
		} else {
			userRole.delete(flush:true)
		}
		render "MANAGED", status: OK
	}
	
	def update(User userInstance) {
		userInstance.save(flush:true)
		response.status = 200
		render "UPDATED"
	}
	
	def resetPassword(User userInstance) {
		userInstance.password = "mude"
		userInstance.save(flush:true)
		response.status = 200
		render "UPDATED"
	}
	
	def editPassword() {
		User currentUser = springSecurityService.getCurrentUser()
		User userInstance = User.findByUsername(currentUser.username)
		
		respond userInstance
	}
	
	def updatePassword(String password) {
		User currentUser = springSecurityService.getCurrentUser()
		User userInstance = User.findByUsername(currentUser.username)
		userInstance.password = password
		userInstance.save(flush:true)
		redirect(uri: "/")
	}
	
	def removeUser (User userInstance) {
		List userRoles = UserRole.findAllByUser(userInstance)
		userRoles.each{
			it.delete(flush:true)
		}
		
		userInstance.delete(flush:true)
		response.status = 200
		render "DELETED"
	}	
}