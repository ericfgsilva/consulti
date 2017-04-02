package br.com.consulti.framework.constants

enum Controller {

    ACTION_INDEX ('index'),
    ACTION_NOT_FOUND ('notFound')

    private final String code;

    private Controller(String code) {
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