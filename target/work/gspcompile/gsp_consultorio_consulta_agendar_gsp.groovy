import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_consulta_agendar_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/consulta/_agendar.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',52,['template':("/consulta/agendar/searchPaciente")],-1)
printHtmlPart(1)
invokeTag('render','g',56,['template':("/consulta/agendar/search")],-1)
printHtmlPart(2)
invokeTag('render','g',60,['template':("/consulta/agendar/selected")],-1)
printHtmlPart(3)
invokeTag('render','g',64,['template':("/consulta/agendar/datahora")],-1)
printHtmlPart(4)
invokeTag('render','g',67,['template':("/consulta/agendar/general")],-1)
printHtmlPart(5)
invokeTag('render','g',70,['template':("/consulta/agendar/summary")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446089175000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
