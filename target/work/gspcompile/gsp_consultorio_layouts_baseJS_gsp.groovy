import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_consultorio_layouts_baseJS_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/_baseJS.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(resource(dir: 'plugins', file: 'jquery-1.8.2/jquery-1.8.2.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'jquery-ui-1.10.4/ui/minified/jquery-ui.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-3.2.0/js/bootstrap.min.js'))
printHtmlPart(2)
expressionOut.print(resource(dir: 'plugins', file: 'slimscroll/jquery.slimscroll.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'jquery-cookie/jquery.cookie.js'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-datepicker/js/bootstrap-datepicker.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'ionRangeSlider/js/ion-rangeSlider/ion.rangeSlider.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-colorpicker/js/bootstrap-colorpicker.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'masked-input/masked-input.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-timepicker/js/bootstrap-timepicker.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'password-indicator/js/password-indicator.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-combobox/js/bootstrap-combobox.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-select/bootstrap-select.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-tagsinput/bootstrap-tagsinput.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-tagsinput/bootstrap-tagsinput-typeahead.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'jquery-tag-it/js/tag-it.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'slimscroll/jquery.slimscroll.min.js'))
printHtmlPart(4)
invokeTag('javascript','asset',28,['src':("form-plugins.demo.min.js")],-1)
printHtmlPart(5)
invokeTag('javascript','asset',29,['src':("form-wysiwyg.demo.min.js")],-1)
printHtmlPart(6)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'plugins', file: 'bootstrap-wysihtml5/src/bootstrap-wysihtml5.js'))
printHtmlPart(7)
invokeTag('javascript','asset',32,['src':("apps.min.js")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1440377051000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
