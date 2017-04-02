import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_usereditPassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/editPassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(resource())
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',13,['class':("btn btn-default btn-circle"),'controller':("paciente"),'action':("index")],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('submitButton','g',21,['name':("create"),'class':("btn btn-primary"),'value':("Alterar")],-1)
printHtmlPart(8)
expressionOut.print(userInstance.username)
printHtmlPart(9)
invokeTag('passwordField','g',29,['class':("form-control"),'name':("password"),'required type':("text"),'value':("")],-1)
printHtmlPart(10)
})
invokeTag('form','g',31,['url':([controller:'user', action:'updatePassword'])],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',33,[:],1)
printHtmlPart(12)
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
