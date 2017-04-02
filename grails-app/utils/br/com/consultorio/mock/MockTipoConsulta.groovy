package br.com.consultorio.mock

import br.com.consultorio.TipoConsulta
import br.com.consultorio.mock.impl.RegisterMockImpl

class MockTipoConsulta implements RegisterMockImpl {

	def mock() {
		if(TipoConsulta.count() == 0){
			TipoConsulta aVez = new TipoConsulta(nome: '1a Vez').save flush:true
			TipoConsulta gineco = new TipoConsulta(nome: 'Ginecologia').save flush:true
			TipoConsulta oMes = new TipoConsulta(nome: '8o Mes').save flush:true
			TipoConsulta periodico = new TipoConsulta(nome: 'Periodico').save flush:true
		}
	}
}
