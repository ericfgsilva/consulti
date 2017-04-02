import br.com.consultorio.Paciente
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_secretariaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/secretaria/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',22,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',23,['var':("entityName"),'value':(message(code: 'secretaria.label', default: 'Secretaria'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',24,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',24,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',24,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(resource())
printHtmlPart(6)
invokeTag('render','g',47,['template':("/general/contadores")],-1)
printHtmlPart(7)
invokeTag('render','g',86,['template':("../consulta/agendar")],-1)
printHtmlPart(8)
invokeTag('render','g',89,['template':("../planoSaude/create")],-1)
printHtmlPart(9)
invokeTag('render','g',92,['template':("../paciente/create")],-1)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',97,[:],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1449579490000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
