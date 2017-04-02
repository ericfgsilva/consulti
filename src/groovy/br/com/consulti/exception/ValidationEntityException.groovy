package br.com.consulti.exception

import org.codehaus.groovy.grails.exceptions.GrailsException

class ValidationEntityException extends GrailsException {

    public ValidationEntityException(String message) {
        super(message)
    }

    public ValidationEntityException() {
        super()
    }
}
