package br.com.consultorio.framework

import br.com.consulti.exception.ValidationEntityException
import br.com.consulti.framework.constants.ContentType
import br.com.consulti.framework.constants.MessageHandler
import org.springframework.http.HttpStatus

/**
 * Sempre que surgir a necessidade de lançar uma nova exceção, então é preciso cadastrar o tratamento dela aqui
 * O grails captura a exceção automaticamente
 */
abstract class ErrorHandlingController {

    /**
     *
     * @param exception
     * @return
     */
    def validationEntityException(final ValidationEntityException exception) {
        exception.printStackTrace()
        request.withFormat {
            json {
                render text: message(code: MessageHandler.ERROR_MESSAGE_EXCEPTION.code),
                        contentType: ContentType.APPLICATION_JSON.type,
                        status: HttpStatus.OK // TODO mudar validação do angular para aceitar BAD_REQUEST
            }
            html {
                flash.errorMessage = message(code: MessageHandler.ERROR_MESSAGE_EXCEPTION.code)
                redirect([action: 'index'])
            }
            form multipartForm {
                flash.errorMessage = message(code: MessageHandler.ERROR_MESSAGE_EXCEPTION.code)
                redirect([action: 'index'])
            }
        }
    }

    /**
     * 
     * @param exception
     * @return
     */
    def exception(final Exception exception) {
        exception.printStackTrace()
        request.withFormat {
            json {
                render text: message(code: MessageHandler.ERROR_MESSAGE_EXCEPTION.code),
                        contentType: ContentType.APPLICATION_JSON.type,
                        status: HttpStatus.OK // TODO mudar validação do angular para aceitar BAD_REQUEST
            }
            html {
                flash.errorMessage = message(code: MessageHandler.ERROR_MESSAGE_EXCEPTION.code)
                redirect([action: 'index'])
            }
            form multipartForm {
                flash.errorMessage = message(code: MessageHandler.ERROR_MESSAGE_EXCEPTION.code)
                redirect([action: 'index'])
            }
        }
    }
}
