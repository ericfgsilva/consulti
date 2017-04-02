import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_consultaedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/consulta/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'consulta.label', default: 'Consulta'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(resource())
printHtmlPart(6)
expressionOut.print(resource())
printHtmlPart(7)
expressionOut.print(consultaInstance.id)
printHtmlPart(8)
expressionOut.print(resource())
printHtmlPart(9)
expressionOut.print(consultaInstance.paciente.id)
printHtmlPart(10)
expressionOut.print(consultaInstance.dia)
printHtmlPart(11)
expressionOut.print(consultaInstance.paciente.nome)
printHtmlPart(12)
if(true && (consultaInstance.horaChegada != null)) {
printHtmlPart(13)
expressionOut.print(consultaInstance.horaChegada)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (consultaInstance.horaSaida != null)) {
printHtmlPart(16)
expressionOut.print(consultaInstance.horaSaida)
printHtmlPart(14)
}
printHtmlPart(17)
if(true && (consultaInstance.planoSaude != null)) {
printHtmlPart(18)
expressionOut.print(consultaInstance.planoSaude.id)
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(consultaInstance.tipoConsulta.id)
printHtmlPart(21)
expressionOut.print(consultaInstance.situacaoConsulta)
printHtmlPart(22)
expressionOut.print(consultaInstance.numeroCarteira)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
expressionOut.print(consultaInstance.descricao)
printHtmlPart(25)
})
invokeTag('access','sec',86,['expression':("hasRole('ROLE_DOCTOR')")],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',89,[:],1)
printHtmlPart(27)
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
