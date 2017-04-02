package br.com.consulti.exception

class PacienteDependencyException extends Exception {

    public PacienteDependencyException(String message) {
        super(message)
    }

    public PacienteDependencyException() {
        super()
    }
}
