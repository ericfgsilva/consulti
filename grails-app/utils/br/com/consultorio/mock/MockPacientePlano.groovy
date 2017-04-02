package br.com.consultorio.mock

import br.com.consultorio.Paciente;
import br.com.consultorio.PacientePlano;
import br.com.consultorio.PlanoSaude;
import br.com.consultorio.mock.impl.RegisterMockImpl;

class MockPacientePlano implements RegisterMockImpl{

	
	def mock() {
		if (PacientePlano.count() == 0){
			new PacientePlano(paciente: Paciente.findById(1), planoSaude: PlanoSaude.findById(1)).save flush:true
			new PacientePlano(paciente: Paciente.findById(2), planoSaude: PlanoSaude.findById(2)).save flush:true
			new PacientePlano(paciente: Paciente.findById(3), planoSaude: PlanoSaude.findById(3)).save flush:true
			new PacientePlano(paciente: Paciente.findById(4), planoSaude: PlanoSaude.findById(4)).save flush:true
			new PacientePlano(paciente: Paciente.findById(5), planoSaude: PlanoSaude.findById(5)).save flush:true
			new PacientePlano(paciente: Paciente.findById(6), planoSaude: PlanoSaude.findById(6)).save flush:true
			new PacientePlano(paciente: Paciente.findById(7), planoSaude: PlanoSaude.findById(7)).save flush:true
			new PacientePlano(paciente: Paciente.findById(8), planoSaude: PlanoSaude.findById(8)).save flush:true
			new PacientePlano(paciente: Paciente.findById(9), planoSaude: PlanoSaude.findById(9)).save flush:true
			new PacientePlano(paciente: Paciente.findById(10), planoSaude: PlanoSaude.findById(10)).save flush:true
			new PacientePlano(paciente: Paciente.findById(11), planoSaude: PlanoSaude.findById(11)).save flush:true
			new PacientePlano(paciente: Paciente.findById(12), planoSaude: PlanoSaude.findById(12)).save flush:true
			new PacientePlano(paciente: Paciente.findById(13), planoSaude: PlanoSaude.findById(13)).save flush:true
			new PacientePlano(paciente: Paciente.findById(14), planoSaude: PlanoSaude.findById(14)).save flush:true
			new PacientePlano(paciente: Paciente.findById(15), planoSaude: PlanoSaude.findById(15)).save flush:true
			new PacientePlano(paciente: Paciente.findById(16), planoSaude: PlanoSaude.findById(16)).save flush:true
			new PacientePlano(paciente: Paciente.findById(17), planoSaude: PlanoSaude.findById(17)).save flush:true
			new PacientePlano(paciente: Paciente.findById(18), planoSaude: PlanoSaude.findById(18)).save flush:true
			new PacientePlano(paciente: Paciente.findById(19), planoSaude: PlanoSaude.findById(19)).save flush:true
			new PacientePlano(paciente: Paciente.findById(20), planoSaude: PlanoSaude.findById(20)).save flush:true
			new PacientePlano(paciente: Paciente.findById(21), planoSaude: PlanoSaude.findById(21)).save flush:true
			new PacientePlano(paciente: Paciente.findById(22), planoSaude: PlanoSaude.findById(22)).save flush:true
			new PacientePlano(paciente: Paciente.findById(23), planoSaude: PlanoSaude.findById(23)).save flush:true
			new PacientePlano(paciente: Paciente.findById(24), planoSaude: PlanoSaude.findById(24)).save flush:true
			new PacientePlano(paciente: Paciente.findById(25), planoSaude: PlanoSaude.findById(25)).save flush:true
			new PacientePlano(paciente: Paciente.findById(26), planoSaude: PlanoSaude.findById(26)).save flush:true
			new PacientePlano(paciente: Paciente.findById(27), planoSaude: PlanoSaude.findById(27)).save flush:true
			new PacientePlano(paciente: Paciente.findById(28), planoSaude: PlanoSaude.findById(28)).save flush:true
			new PacientePlano(paciente: Paciente.findById(29), planoSaude: PlanoSaude.findById(29)).save flush:true
			new PacientePlano(paciente: Paciente.findById(30), planoSaude: PlanoSaude.findById(30)).save flush:true
			new PacientePlano(paciente: Paciente.findById(31), planoSaude: PlanoSaude.findById(31)).save flush:true
			new PacientePlano(paciente: Paciente.findById(32), planoSaude: PlanoSaude.findById(32)).save flush:true
			new PacientePlano(paciente: Paciente.findById(33), planoSaude: PlanoSaude.findById(33)).save flush:true
			new PacientePlano(paciente: Paciente.findById(34), planoSaude: PlanoSaude.findById(34)).save flush:true
			new PacientePlano(paciente: Paciente.findById(35), planoSaude: PlanoSaude.findById(35)).save flush:true
			new PacientePlano(paciente: Paciente.findById(36), planoSaude: PlanoSaude.findById(36)).save flush:true
			new PacientePlano(paciente: Paciente.findById(37), planoSaude: PlanoSaude.findById(37)).save flush:true
			new PacientePlano(paciente: Paciente.findById(38), planoSaude: PlanoSaude.findById(38)).save flush:true
			new PacientePlano(paciente: Paciente.findById(39), planoSaude: PlanoSaude.findById(39)).save flush:true
			new PacientePlano(paciente: Paciente.findById(40), planoSaude: PlanoSaude.findById(40)).save flush:true
			new PacientePlano(paciente: Paciente.findById(41), planoSaude: PlanoSaude.findById(41)).save flush:true
			new PacientePlano(paciente: Paciente.findById(42), planoSaude: PlanoSaude.findById(42)).save flush:true
			new PacientePlano(paciente: Paciente.findById(43), planoSaude: PlanoSaude.findById(43)).save flush:true
			new PacientePlano(paciente: Paciente.findById(44), planoSaude: PlanoSaude.findById(44)).save flush:true
			new PacientePlano(paciente: Paciente.findById(45), planoSaude: PlanoSaude.findById(45)).save flush:true
			new PacientePlano(paciente: Paciente.findById(46), planoSaude: PlanoSaude.findById(46)).save flush:true
			new PacientePlano(paciente: Paciente.findById(47), planoSaude: PlanoSaude.findById(47)).save flush:true
			new PacientePlano(paciente: Paciente.findById(48), planoSaude: PlanoSaude.findById(48)).save flush:true
			new PacientePlano(paciente: Paciente.findById(49), planoSaude: PlanoSaude.findById(49)).save flush:true
			new PacientePlano(paciente: Paciente.findById(50), planoSaude: PlanoSaude.findById(50)).save flush:true
			new PacientePlano(paciente: Paciente.findById(51), planoSaude: PlanoSaude.findById(51)).save flush:true
			new PacientePlano(paciente: Paciente.findById(52), planoSaude: PlanoSaude.findById(52)).save flush:true
			new PacientePlano(paciente: Paciente.findById(53), planoSaude: PlanoSaude.findById(53)).save flush:true
			new PacientePlano(paciente: Paciente.findById(54), planoSaude: PlanoSaude.findById(54)).save flush:true
			new PacientePlano(paciente: Paciente.findById(55), planoSaude: PlanoSaude.findById(55)).save flush:true
			new PacientePlano(paciente: Paciente.findById(56), planoSaude: PlanoSaude.findById(56)).save flush:true
			new PacientePlano(paciente: Paciente.findById(57), planoSaude: PlanoSaude.findById(57)).save flush:true
			new PacientePlano(paciente: Paciente.findById(58), planoSaude: PlanoSaude.findById(58)).save flush:true
			new PacientePlano(paciente: Paciente.findById(59), planoSaude: PlanoSaude.findById(59)).save flush:true
			new PacientePlano(paciente: Paciente.findById(60), planoSaude: PlanoSaude.findById(60)).save flush:true
			
		}
	}

}
