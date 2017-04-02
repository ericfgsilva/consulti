package br.com.consultorio.services.mock

import br.com.consultorio.mock.impl.RegisterMockImpl;


class RegisterMockService {

    List mockServices = []
 
    def mock() {
        mockServices.each{ RegisterMockImpl mockService ->
			mockService.mock()
		}
    }
}
