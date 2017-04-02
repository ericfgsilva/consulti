package br.com.consulti.framework.constants

enum Method {

    GET ('GET'),
    POST ('GET'),
    PUT ('GET'),
    DELETE ('DELETE')

    private final String code;

    private Method(String code) {
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