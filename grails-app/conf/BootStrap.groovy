
import br.com.consultorio.*
import br.com.consultorio.security.Role
import br.com.consultorio.security.User
import br.com.consultorio.security.UserRole

class BootStrap {
    
    def grailsApplication

    def init = { servletContext ->
        
        grailsApplication.mainContext.getBean("registerJSONMarshallerService").register()
		grailsApplication.mainContext.getBean("registerMockService").mock()
    }
	
    def destroy = {
    }
}
