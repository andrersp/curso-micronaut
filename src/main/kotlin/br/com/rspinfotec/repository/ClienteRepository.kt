package br.com.rspinfotec.repository

import br.com.rspinfotec.model.Cliente
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.transaction.annotation.Transactional
import jakarta.persistence.EntityManager


@Repository
abstract class ClienteRepository(private val entityManager: EntityManager) : JpaRepository<Cliente, Long> {
    abstract fun findByNome(nome: String, pageable: Pageable): Page<Cliente>

    @Query("select c from Cliente c")
    abstract fun listClients(): List<Cliente>

    @Transactional
    open fun listClientsImplementacao(nome: String?): List<Cliente> {
        var stmt = "select c from Cliente c"
        if (nome != null) {
            stmt = "$stmt where c.nome LIKE :nome"
        }
        var query = entityManager.createQuery(stmt, Cliente::class.java)

        if (nome != null) {
            query.setParameter("nome", "%$nome%")
        }

        return query.resultList
    }
}