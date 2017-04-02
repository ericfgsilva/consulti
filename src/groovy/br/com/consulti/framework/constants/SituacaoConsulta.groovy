package br.com.consulti.framework.constants

/**
 * Clase de constantes utilizada para apresentar a situação das consultas médicas
 */
public enum SituacaoConsulta {

    MARCADO    ( 1, 'marcado'    ),
    ANDAMENTO  ( 2, 'andamento'  ),
    CANCELADO  ( 3, 'cancelado'  ),
    CONSULTADO ( 4, 'consultado' )

    Integer id
    String nome

    /**
     * Construtor
     * @param id identificador do elemento
     * @param nome nome que representa o elemento
     */
    SituacaoConsulta(Integer id, String nome) {
        this.id = id
        this.nome = nome
    }

    static SituacaoConsulta findById(Integer id) {
        return values().find { it.id == id }
    }

    static SituacaoConsulta findByNome(String nome) {
        return values().find { it.nome == nome }
    }
}
