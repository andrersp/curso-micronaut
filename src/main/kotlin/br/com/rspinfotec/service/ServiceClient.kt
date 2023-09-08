package br.com.rspinfotec.service

import br.com.rspinfotec.exception.NotFoudException
import br.com.rspinfotec.model.Cliente
import br.com.rspinfotec.repository.ClienteRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.transaction.annotation.Transactional
import jakarta.inject.Singleton

@Singleton
open class ServiceClient(private val repositoryClient: ClienteRepository) {

    @Transactional
    open fun updateClient(clientID: Long, client: Cliente) {
        val clientDB = getClientByID(clientID = clientID)
        clientDB.nome = client.nome
        clientDB.endereco = client.endereco
        client.documento = client.documento
        repositoryClient.save(clientDB)
    }

    fun deleteCliente(clientID: Long) {
        repositoryClient.deleteById(clientID)
    }

    fun getClientByID(clientID: Long): Cliente {
        return repositoryClient.findById(clientID).orElseThrow {
            NotFoudException("Usuario nao encontrado")
        }
    }

    fun getAllClients(nome: String?, pageable: Pageable): Page<Cliente> {
        if (nome != null) {
            return repositoryClient.findByNome(nome.toString(), pageable)
        }
        return repositoryClient.findAll(pageable)
    }

    fun listClients(nome: String?): List<Cliente> = repositoryClient.listClientsImplementacao(nome)


    fun saveClient(client: Cliente): Cliente = repositoryClient.save(client)
}
