import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_layouts_baseAngularJS_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_baseAngularJS.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('javascript','g',1,['src':("vendor/angular.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',2,['src':("app/ui-bootstrap-tpls-0.11.0.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',3,['src':("/vendor/angular-dragdrop.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',4,['src':("app/configService.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',5,['src':("app/messageService.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',6,['src':("rest/atendimentoService.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',7,['src':("rest/consultaService.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',8,['src':("rest/documentService.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',9,['src':("rest/pacienteService.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',10,['src':("rest/planoSaudeService.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',11,['src':("atendimento.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',12,['src':("angularCalendario.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',13,['src':("angularConsulta.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',14,['src':("angularPlanoSaude.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',15,['src':("angularPaciente.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',16,['src':("angularSecretaria.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',17,['src':("crud.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',18,['src':("angularTipoConsulta.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',19,['src':("angularUsuario.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',20,['src':("filter.js")],-1)
printHtmlPart(0)
invokeTag('javascript','g',1,['src':("app/smart-table.js")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1449364593000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
