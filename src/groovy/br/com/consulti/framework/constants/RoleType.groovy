package br.com.consulti.framework.constants

/**
 * Clase de constantes utilizada para apresentar os perfis de acesso
 */
public enum RoleType {

    ROLE_ADMIN ( 1, 'ROLE_ADMIN', 'Administrador'),
    ROLE_DOCTOR ( 2, 'ROLE_DOCTOR', 'Médico'),
    ROLE_USER ( 3, 'ROLE_USER', 'Usuário Comum')

    Integer id
    String name
    String simpleName

    /**
     * Construtor
     * @param id identificador do elemento
     * @param name nome que representa o elemento
     * @param simpleNome nome representativo
     */
    RoleType(Integer id, String nome, String simpleName) {
        this.id = id
        this.name = nome
        this.simpleName = simpleName
    }

    static RoleType findById(Integer id) {
        return values().find { it.id == id }
    }

    static RoleType findByName(String name) {
        return values().find { it.name == name }
    }

    @Override
    public String toString() {
        return name
    }
}
