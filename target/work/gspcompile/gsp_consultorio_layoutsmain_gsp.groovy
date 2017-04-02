import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':(""),'name':("description")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':(""),'name':("author")],-1)
printHtmlPart(4)
invokeTag('render','g',12,['template':("/layouts/baseCSS")],-1)
printHtmlPart(4)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',14,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(1)
invokeTag('layoutHead','g',15,[:],-1)
printHtmlPart(1)

response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            response.setDateHeader("Expires", 0);
            response.setHeader("Pragma","no-cache");

printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('render','g',34,['template':("/layouts/navbar/header")],-1)
printHtmlPart(7)
invokeTag('render','g',35,['template':("/layouts/navbar/menu")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',43,['name':("config"),'data-resource':(resource()),'value':("config")],-1)
printHtmlPart(9)
invokeTag('layoutBody','g',44,[:],-1)
printHtmlPart(10)
invokeTag('render','g',47,['template':("/layouts/confirmationMessage"),'model':(['messageClass':'alert-warning', 'title': 'Tem certeza?'])],-1)
printHtmlPart(11)
invokeTag('render','g',50,['template':("/layouts/message"),'model':(['messageClass':'alert-success', 'title': 'Sucesso!'])],-1)
printHtmlPart(12)
invokeTag('render','g',53,['template':("/layouts/message"),'model':(['messageClass':'alert-danger', 'title': 'Erro!'])],-1)
printHtmlPart(13)
invokeTag('render','g',57,['template':("/layouts/document")],-1)
printHtmlPart(14)
invokeTag('render','g',62,['template':("/layouts/baseJS")],-1)
printHtmlPart(1)
invokeTag('appJS','js',63,[:],-1)
printHtmlPart(5)
})
invokeTag('captureBody','sitemesh',64,['ng-app':("Consultorio")],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446082533000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
