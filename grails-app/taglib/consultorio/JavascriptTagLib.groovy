package consultorio

class JavascriptTagLib {
    static namespace = 'js'

    static defaultEncodeAs = "raw"

    /**
     <g:javascript src="vendor/angular.js" />
     <g:javascript src="app/app.js" />

     <g:javascript src="app/ui-bootstrap-tpls-0.11.0.js" />
     <g:javascript src="/vendor/angular-dragdrop.js" />

     <g:javascript src="app/configService.js" />
     <g:javascript src="app/messageService.js" />

     <g:javascript src="rest/atendimentoService.js" />
     <g:javascript src="rest/consultaService.js" />
     <g:javascript src="rest/documentService.js" />
     <g:javascript src="rest/pacienteService.js" />
     <g:javascript src="rest/planoSaudeService.js" />

     <g:javascript src="angularAtendimento.js" />
     <g:javascript src="atendimento.js" />
     <g:javascript src="angularCalendario.js" />
     <g:javascript src="angularConsulta.js" />
     <g:javascript src="angularPlanoSaude.js" />
     <g:javascript src="angularPaciente.js" />
     <g:javascript src="angularSecretaria.js" />
     <g:javascript src="crud.js" />
     <g:javascript src="angularTipoConsulta.js" />
     <g:javascript src="angularUsuario.js" />


     <g:javascript src="filter.js" />
     <g:javascript src="app/smart-table.js" />

     ${g.javascript([:], dropzoneInitJS)}
     ${asset.javascript(src:'controllers/common/pstruct.js' )}
     ${asset.javascript(src: 'controllers/common/attachments.js')}
     */

    List listOfAngularAppClasses = ['configService', 'messageService']
    List listOfAngularUIClasses = ['atendimento', 'prontuario', 'angularCalendario', 'contador',
                                   'angularConsulta', 'angularPlanoSaude', 'angularPaciente', 'angularSecretaria',
                                   'crud', 'angularTipoConsulta', 'angularUsuario']
    List listOfAngularRestClasses = ['atendimentoService', 'consultaService', 'documentService',
                                     'pacienteService', 'planoSaudeService']

    Closure appJS = { attrs, body ->
        out << """
            <script type="text/javascript" >
                var consultiModules = [];
            </script>
        """

        out << """
            ${g.javascript(src: 'vendor/angular.js')}
            ${g.javascript(src: 'app/ui-bootstrap-tpls-0.11.0.js')}
            ${g.javascript(src: 'vendor/angular-dragdrop.js')}
        """

        listOfAngularAppClasses.each { js ->
            out << g.javascript(src: "app/${js}.js")
        }

        listOfAngularRestClasses.each { js ->
            out << g.javascript(src: "rest/${js}.js")
        }

        listOfAngularUIClasses.each { js ->
            out << g.javascript(src: "${js}.js")
        }

        out << """
            ${g.javascript(src: 'filter.js')}
            ${g.javascript(src: 'app/smart-table.js')}
        """

        out << """
            <script type="text/javascript" >
                consultiModules.push('ui.bootstrap');
                var app = angular.module("Consultorio", consultiModules);
            </script>
        """
    }
}
