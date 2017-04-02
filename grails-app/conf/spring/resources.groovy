import br.com.consultorio.marshaller.*
import br.com.consultorio.mock.MockConsulta;
import br.com.consultorio.mock.MockPaciente
import br.com.consultorio.mock.MockPacientePlano;
import br.com.consultorio.mock.MockPlanoSaude;
import br.com.consultorio.mock.MockTipoConsulta
import br.com.consultorio.mock.MockTipoDocumento;
import br.com.consultorio.mock.MockUser
import br.com.consultorio.services.mock.RegisterMockService
// Place your Spring DSL code here
beans = {
    registerJSONMarshallerService( RegisterJSONMarshallerService ) {
        marshallers = [
            new ConsultaJSONMarshaller(),
			new UserJSONMarshaller(),
			new UserRoleJSONMarshaller(),
			new TipoConsultaJSONMarshaller(),
			new PlanoSaudeJSONMarshaller(),
			new PacienteJSONMarshaller(),
			new PacientePlanoJSONMarshaller(),
			new ProntuarioJSONMarshaller()
        ]
    }
	
	registerMockService( RegisterMockService ) {
		mockServices = [
			new MockTipoConsulta(),
			new MockTipoDocumento(),
			new MockUser(),
			new MockPaciente(),
			new MockPlanoSaude(),
			new MockPacientePlano(),
			new MockConsulta()
		]
	}
}
