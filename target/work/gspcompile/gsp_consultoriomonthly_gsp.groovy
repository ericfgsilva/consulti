import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultoriomonthly_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/monthly.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
expressionOut.print(resource(dir: 'css', file: 'sb-admin-2.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: '/plugins/timeline.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: '/plugins/metisMenu/metisMenu.min.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: '/plugins/morris.min.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'font-awesome', file: '/css/font-awesome.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: 'bootstrap.min.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css', file: 'modal.css'))
printHtmlPart(7)
invokeTag('captureMeta','sitemesh',22,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(8)
invokeTag('javascript','g',23,['src':("functions.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',24,['src':("jquery-1.11.1.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',25,['src':("tela.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',26,['src':("vendor/angular.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',27,['src':("app/app.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',28,['src':("ui-bootstrap-tpls-0.11.0.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',29,['src':("sb-admin.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',30,['src':("/plugins/morris/morris.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',31,['src':("/plugins/morris/raphael-2.1.0.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',32,['src':("/plugins/metisMenu/jquery.metisMenu.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',33,['src':("bootstrap.min.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',34,['src':("app/modal.js")],-1)
printHtmlPart(10)
invokeTag('javascript','g',37,['src':("angularAtendimento.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',38,['src':("angularCalendario.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',39,['src':("angularConsulta.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',40,['src':("angularPaciente.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',41,['src':("angularPlanoSaude.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',42,['src':("angularTipoConsulta.js")],-1)
printHtmlPart(9)
invokeTag('javascript','g',43,['src':("angularUsuario.js")],-1)
printHtmlPart(8)
invokeTag('javascript','g',44,['src':("filter.js")],-1)
printHtmlPart(11)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',48,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',48,[:],2)
printHtmlPart(12)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',58,[:],1)
printHtmlPart(14)
createClosureForHtmlPart(15, 1)
invokeTag('captureBody','sitemesh',937,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1435789635000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
