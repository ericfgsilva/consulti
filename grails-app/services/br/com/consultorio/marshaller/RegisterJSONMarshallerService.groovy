package br.com.consultorio.marshaller

import grails.transaction.Transactional

@Transactional
class RegisterJSONMarshallerService {

    List marshallers = []
 
    def register() {
        marshallers.each{ it.register() }
    }
}
