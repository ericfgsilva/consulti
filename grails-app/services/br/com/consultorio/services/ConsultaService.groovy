package br.com.consultorio.services

import br.com.consulti.command.AtendimentoCommand
import br.com.consulti.command.ConsultaCommand
import br.com.consulti.framework.constants.RoleType
import br.com.consulti.framework.constants.SituacaoConsulta
import br.com.consultorio.Consulta
import br.com.consultorio.Paciente
import br.com.consultorio.PacientePlano
import br.com.consultorio.PlanoSaude
import br.com.consultorio.Prontuario
import br.com.consultorio.security.User
import br.com.consultorio.security.UserRole
import grails.transaction.Transactional

@Transactional
class ConsultaService {
    public static String CONSULTA_PARTICULAR = 'Consulta Particular'
    public static String TIPO_PLANO_SAUDE = 'plano'
    public static String TIPO_USUARIO = 'usuario'

    /**
     *
     * @param status
     * @param date
     * @param params
     * @return
     */
    List listByStatusAndDate(String status, Date date, Map params) {
        List appointments
        SituacaoConsulta situacao = SituacaoConsulta.findByNome(status)

        appointments = Consulta.createCriteria().list(params) {
            eq("dia", date.clearTime())
            if(status) {
                eq('situacaoConsulta', situacao)
            }
        }

        return appointments
    }

    /**
     *
     * @param consulta
     * @return
     */
    def isPlanoDeSaudeValido (Consulta consulta){
        return consulta.planoSaude == null ? false : true
    }

    /**
     *
     * @return
     */
    def getPlanoDeSaudeParticular() {
        PlanoSaude ps = new PlanoSaude()
        ps.nome = "Particular"
        return ps
    }

    /**
     *
     * @param date
     * @return
     */
    List list(Date date) {
        List lista = Consulta.withCriteria{
            if(date != null){
                eq("dia", date)
            }
        }

        for (Consulta consulta : lista){
            if (!isPlanoDeSaudeValido(consulta)){
                PlanoSaude ps = getPlanoDeSaudeParticular()
                consulta.planoSaude = ps
            }
        }

        return lista
    }

    /**
     *
     * @param date
     * @return
     */
    Map listGroupByProtuario(Date date){
        def consultas = Consulta.withCriteria{
            if(date != null){
                eq("dia", date)
            }
        }

        Map mapedList = consultas.groupBy { Consulta consulta ->
            consulta.prontuario.medico
        }

        return mapedList
    }

    /**
     *
     * @return
     */
    List listPlanoSaudeAndUser(String param) {
        List parameters = []
        Paciente paciente = Paciente.get(param)

        /*
        obter todos os planos de saúde de um paciente
         */
        List planos = PacientePlano.findAllByPaciente(paciente)
        parameters << ['id': '', 'nome': CONSULTA_PARTICULAR, 'tipo': TIPO_PLANO_SAUDE]
        planos.each { PacientePlano plano ->
            parameters << ['id': plano.planoSaude.id, 'nome': plano.planoSaude.nome, 'tipo': TIPO_PLANO_SAUDE]
        }

        /*
        obter todos os usuários que são médicos para o atendimento
         */
        UserRole.list().each {UserRole role ->
            if (role.role.authority == RoleType.ROLE_DOCTOR.name){
                User usuario = User.findById(role.user.id)
                parameters << ['id': usuario.id, 'nome': usuario.username, 'tipo': TIPO_USUARIO]
            }
        }

        // organizar lista
        parameters.sort(true){
            it.nome.toLowerCase()
        }

        return parameters
    }

    void verificarSituacaoConsulta(ConsultaCommand consultaCommand, SituacaoConsulta situacao) {
        if (consultaCommand?.id == null) {
            // TODO throw exception
        }

        Consulta consulta = Consulta.findByIdAndSituacaoConsulta(consultaCommand.id, situacao)

        if (consulta == null) {
            // TODO throw exception
        }
    }

    void resetConsultasEmAtendimento() {
        List<Consulta> consultas = Consulta.findAllBySituacaoConsulta(SituacaoConsulta.ANDAMENTO)
        consultas.each { Consulta consulta ->
            consulta.situacaoConsulta = SituacaoConsulta.MARCADO
            consulta.save()
        }
    }

    void agendarConsulta (ConsultaCommand consultaCommand) {

    }

    AtendimentoCommand getConsultaByAtendimento(ConsultaCommand consultaCommand) {
        AtendimentoCommand atendimento = new AtendimentoCommand()
        Consulta consulta = getConsulta(consultaCommand)
        Prontuario prontuario = Prontuario.findById(consulta.prontuario.id)

        if (prontuario == null) {
            // TODO throw exception
        }

        /*
        Organizando consultas
         */
        List<Consulta> consultas = prontuario.consultas.sort { it.dia }
        List<Consulta> consultasEmAndamento = consultas.findAll { it.situacaoConsulta == SituacaoConsulta.ANDAMENTO }
        consultas.removeAll { it.situacaoConsulta == SituacaoConsulta.ANDAMENTO }

        /*
        preenchendo
         */
        atendimento.consulta = consulta
        atendimento.consultas = []
        atendimento.consultas.addAll(consultasEmAndamento)
        atendimento.consultas.addAll(consultas)
        atendimento.medico = prontuario.medico
        atendimento.paciente = prontuario.paciente

        return atendimento
    }

    Consulta getConsulta(ConsultaCommand consultaCommand) {
        if (consultaCommand?.id == null) {
            // TODO throw exception
        }

        Consulta consulta = Consulta.findById(consultaCommand.id)

        if (consulta == null) {
            // TODO throw exception
        }

        return consulta
    }

    void setSituacaoConsulta(ConsultaCommand consultaCommand, SituacaoConsulta situacao) {
        Consulta consulta = getConsulta(consultaCommand)
        consulta.situacaoConsulta = situacao
        consulta.save()
    }

    List<Consulta> listConsultas(SituacaoConsulta situacao, Date dataConsulta = null, User medico = null) {
        List<Consulta> consultas = Consulta.createCriteria().list() {
            if (dataConsulta != null) {
                eq('dia', dataConsulta)
            }

            if (medico) {
                prontuario {
                    eq('medico', medico.username)
                }
            }

            eq('situacaoConsulta', situacao)
        }

        return consultas
    }

    Integer countBySituacaoConsulta(SituacaoConsulta situacao, Date dataConsulta = null) {
        List<Consulta> consultas = listConsultas (situacao, dataConsulta)
        Integer count = consultas?.size() ?: 0
        return count
    }

    void saveDescricaoConsulta(ConsultaCommand consultaCommand) {
        Consulta consulta = getConsulta(consultaCommand)
        consulta.descricao = consultaCommand.descricao
        consulta.save()
    }
}
