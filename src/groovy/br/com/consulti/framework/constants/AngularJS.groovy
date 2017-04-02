package br.com.consulti.framework.constants

/**
 * Clase de constantes utilizada para apresentar a situação das consultas médicas
 */
public enum AngularJS {

    SECRETARIA (1, 'marcado')

    Integer id
    String nome

    /**
     * Construtor
     * @param id identificador do elemento
     * @param nome nome que representa o elemento
     */
    AngularJS(Integer id, String nome) {
        this.id = id
        this.nome = nome
    }

    static AngularJS findById(Integer id) {
        return values().find { it.id == id }
    }

    static AngularJS findByNome(String nome) {
        return values().find { it.nome == nome }
    }
}
