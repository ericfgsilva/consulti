import br.com.consultorio.Consulta
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_consultashow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/consulta/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'consulta.label', default: 'Consulta'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(resource())
printHtmlPart(6)
expressionOut.print(resource())
printHtmlPart(7)
expressionOut.print(consultaInstance.dia)
printHtmlPart(8)
expressionOut.print(consultaInstance.paciente.nome)
printHtmlPart(9)
expressionOut.print(consultaInstance.horaChegada)
printHtmlPart(10)
expressionOut.print(consultaInstance.horaSaida)
printHtmlPart(11)
expressionOut.print(consultaInstance?.planoSaude?.nome)
printHtmlPart(12)
expressionOut.print(consultaInstance.tipoConsulta.id)
printHtmlPart(13)
expressionOut.print(consultaInstance.tipoConsulta.tipo)
printHtmlPart(14)
expressionOut.print(consultaInstance.situacaoConsulta)
printHtmlPart(15)
expressionOut.print(consultaInstance.numeroCarteira)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(consultaInstance.paciente.descricao)
printHtmlPart(18)
})
invokeTag('access','sec',63,['expression':("hasRole('ROLE_DOCTOR')")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419554567000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
