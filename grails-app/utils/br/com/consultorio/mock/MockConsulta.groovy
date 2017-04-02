package br.com.consultorio.mock

import br.com.consulti.framework.constants.SituacaoConsulta
import br.com.consultorio.Consulta
import br.com.consultorio.Paciente;
import br.com.consultorio.Prontuario;
import br.com.consultorio.TipoConsulta;
import br.com.consultorio.mock.impl.RegisterMockImpl
import br.com.consultorio.security.User

class MockConsulta implements RegisterMockImpl {

	def mock() {
		Random rand = new Random()

		if(Prontuario.count() == 0) {
			for (int i = 0; i < 100; i++) {
				Long id = rand.nextInt(99) + 1
				new Prontuario (paciente : Paciente.findById(id), medico : 'paula', compartilhado: false).save (flush:true, failOnError:  true)
			}
		}

		if(Consulta.count() == 0) {
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "02/05/2014"), prontuario : Prontuario.findById(26), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save (flush:true, failOnError:  true)
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "05/03/2015"), prontuario : Prontuario.findById(29), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "27/04/2014"), prontuario : Prontuario.findById(20), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "22/01/2015"), prontuario : Prontuario.findById(20), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "10/09/2015"), prontuario : Prontuario.findById(46), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "11/07/2014"), prontuario : Prontuario.findById(20), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "20/06/2015"), prontuario : Prontuario.findById(96), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "16/01/2015"), prontuario : Prontuario.findById(63), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "29/06/2015"), prontuario : Prontuario.findById(8), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "14/02/2014"), prontuario : Prontuario.findById(86), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "05/04/2014"), prontuario : Prontuario.findById(79), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "04/01/2015"), prontuario : Prontuario.findById(74), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "22/04/2014"), prontuario : Prontuario.findById(95), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/05/2014"), prontuario : Prontuario.findById(77), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "01/10/2014"), prontuario : Prontuario.findById(79), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "27/09/2014"), prontuario : Prontuario.findById(55), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/10/2015"), prontuario : Prontuario.findById(17), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/09/2015"), prontuario : Prontuario.findById(1), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "13/08/2015"), prontuario : Prontuario.findById(55), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "19/10/2014"), prontuario : Prontuario.findById(21), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/06/2015"), prontuario : Prontuario.findById(64), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "11/04/2014"), prontuario : Prontuario.findById(84), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "18/05/2015"), prontuario : Prontuario.findById(90), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "15/12/2014"), prontuario : Prontuario.findById(82), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "08/04/2015"), prontuario : Prontuario.findById(68), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "18/04/2014"), prontuario : Prontuario.findById(62), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "28/07/2015"), prontuario : Prontuario.findById(68), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "03/08/2015"), prontuario : Prontuario.findById(93), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "30/07/2015"), prontuario : Prontuario.findById(47), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "23/10/2014"), prontuario : Prontuario.findById(52), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "25/03/2014"), prontuario : Prontuario.findById(85), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "04/12/2014"), prontuario : Prontuario.findById(59), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "15/02/2014"), prontuario : Prontuario.findById(34), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "06/12/2014"), prontuario : Prontuario.findById(42), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "17/11/2015"), prontuario : Prontuario.findById(74), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "02/08/2014"), prontuario : Prontuario.findById(87), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "04/01/2015"), prontuario : Prontuario.findById(83), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "23/04/2014"), prontuario : Prontuario.findById(72), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "26/02/2014"), prontuario : Prontuario.findById(86), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "14/04/2015"), prontuario : Prontuario.findById(18), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "01/03/2014"), prontuario : Prontuario.findById(97), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "17/11/2014"), prontuario : Prontuario.findById(95), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "08/11/2014"), prontuario : Prontuario.findById(84), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "31/08/2014"), prontuario : Prontuario.findById(22), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "15/12/2014"), prontuario : Prontuario.findById(57), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "05/12/2014"), prontuario : Prontuario.findById(33), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "08/04/2015"), prontuario : Prontuario.findById(59), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "22/08/2015"), prontuario : Prontuario.findById(49), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "21/08/2014"), prontuario : Prontuario.findById(58), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "10/11/2014"), prontuario : Prontuario.findById(22), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "13/05/2015"), prontuario : Prontuario.findById(9), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "13/11/2014"), prontuario : Prontuario.findById(45), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "30/05/2015"), prontuario : Prontuario.findById(59), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "22/06/2014"), prontuario : Prontuario.findById(59), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "01/08/2014"), prontuario : Prontuario.findById(15), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "03/10/2014"), prontuario : Prontuario.findById(71), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "14/09/2014"), prontuario : Prontuario.findById(58), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "13/08/2015"), prontuario : Prontuario.findById(55), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "21/08/2015"), prontuario : Prontuario.findById(88), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "05/11/2014"), prontuario : Prontuario.findById(54), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "28/07/2015"), prontuario : Prontuario.findById(52), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "01/09/2014"), prontuario : Prontuario.findById(33), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/07/2014"), prontuario : Prontuario.findById(9), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "26/03/2015"), prontuario : Prontuario.findById(91), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "26/04/2014"), prontuario : Prontuario.findById(58), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "16/02/2014"), prontuario : Prontuario.findById(81), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "18/02/2015"), prontuario : Prontuario.findById(31), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "09/04/2015"), prontuario : Prontuario.findById(93), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "16/12/2014"), prontuario : Prontuario.findById(76), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "24/11/2014"), prontuario : Prontuario.findById(16), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "21/01/2015"), prontuario : Prontuario.findById(67), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "29/06/2015"), prontuario : Prontuario.findById(94), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "28/08/2014"), prontuario : Prontuario.findById(17), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "12/03/2015"), prontuario : Prontuario.findById(3), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "21/04/2015"), prontuario : Prontuario.findById(92), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/08/2014"), prontuario : Prontuario.findById(96), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "24/07/2014"), prontuario : Prontuario.findById(70), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "06/07/2015"), prontuario : Prontuario.findById(55), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/12/2014"), prontuario : Prontuario.findById(84), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "10/05/2014"), prontuario : Prontuario.findById(40), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "06/05/2014"), prontuario : Prontuario.findById(15), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "08/10/2014"), prontuario : Prontuario.findById(78), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "10/03/2014"), prontuario : Prontuario.findById(91), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "12/03/2015"), prontuario : Prontuario.findById(68), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "04/08/2015"), prontuario : Prontuario.findById(43), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "05/04/2014"), prontuario : Prontuario.findById(86), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "03/03/2015"), prontuario : Prontuario.findById(21), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "21/05/2015"), prontuario : Prontuario.findById(76), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "04/07/2015"), prontuario : Prontuario.findById(12), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "19/08/2015"), prontuario : Prontuario.findById(73), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "08/06/2014"), prontuario : Prontuario.findById(8), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/08/2015"), prontuario : Prontuario.findById(86), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "02/06/2015"), prontuario : Prontuario.findById(40), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "05/12/2014"), prontuario : Prontuario.findById(43), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "12/09/2015"), prontuario : Prontuario.findById(31), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "23/10/2014"), prontuario : Prontuario.findById(36), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "15/06/2015"), prontuario : Prontuario.findById(60), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/08/2014"), prontuario : Prontuario.findById(39), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "07/07/2015"), prontuario : Prontuario.findById(90), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().parse("dd/MM/yyyy", "30/07/2015"), prontuario : Prontuario.findById(19), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			
			// Pacientes do dia
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(92), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(96), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(70), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(55), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(84), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(40), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(15), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(78), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(91), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(68), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(43), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(86), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(21), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(76), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(12), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(73), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(8), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(87), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(45), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(47), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(31), tipoConsulta: TipoConsulta.findById(1), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(36), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(60), tipoConsulta: TipoConsulta.findById(2), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(39), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(93), tipoConsulta: TipoConsulta.findById(3), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
			new Consulta(dia: new Date().clearTime(), prontuario : Prontuario.findById(19), tipoConsulta: TipoConsulta.findById(4), situacaoConsulta: SituacaoConsulta.MARCADO, createdByUser: "admin").save flush:true
		}
	}
}
