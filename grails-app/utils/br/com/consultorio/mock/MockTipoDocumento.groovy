package br.com.consultorio.mock

import br.com.consultorio.TipoConsulta
import br.com.consultorio.TipoDocumento;
import br.com.consultorio.mock.impl.RegisterMockImpl

class MockTipoDocumento implements RegisterMockImpl {

	def mock() {
		if(TipoDocumento.count() == 0){
			TipoDocumento prescricao = new TipoDocumento(name: 'prescricao', fullName: 'Prescri��o M�dica').save flush:true
			TipoDocumento atestado = new TipoDocumento(name: 'atestado', fullName: 'Atestado M�dico').save flush:true
		}
	}
}
