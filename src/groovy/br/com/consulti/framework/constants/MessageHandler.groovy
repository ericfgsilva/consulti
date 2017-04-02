package br.com.consulti.framework.constants

enum MessageHandler {

    ERROR_MESSAGE_EXCEPTION ('consulti.error.exception.message'),
    SAVE_SUCCESS ('consulti.success.save'),
    UPDATE_SUCCESS ('consulti.success.update'),
    PRESCRICAO_SAVE_SUCCESS ('consulti.prescricao.success.save'),
    ATESTADO_SAVE_SUCCESS ('consulti.atestado.success.save'),
    REMOVE_SUCCESS ('consulti.success.remove'),
    ERROR_PACIENTE_CONSULTARELACIONADA ('consulti.paciente.error.consultaRelacionada')

    private final String code;

    private MessageHandler(String code) {
        this.code = code
    }

    public String getCode() {
        return code
    }

    @Override
    public String toString() {
        return code
    }
}