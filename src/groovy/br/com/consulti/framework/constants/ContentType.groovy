package br.com.consulti.framework.constants

enum ContentType {

    APPLICATION_JSON ('application/json')

    private final String type;

    private ContentType(String type) {
        this.type = type
    }

    public String getType() {
        return type
    }

    @Override
    public String toString() {
        return type
    }
}