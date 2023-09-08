package br.com.rspinfotec.controller

import br.com.rspinfotec.model.Cliente
import br.com.rspinfotec.service.ServiceClient
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

@Controller("/clientes")
class ClienteController(
    private val clientService: ServiceClient
) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body client: Cliente) = clientService.saveClient(client)

    @Get
    fun findAll(@QueryValue nome: String?, pageable: Pageable): Page<Cliente> =
        clientService.getAllClients(nome, pageable)

    @Get("/{clientID}")
    fun getClient(@PathVariable clientID: Long) = clientService.getClientByID(clientID = clientID)

    @Delete("/{id}")
    fun deleteClient(@PathVariable id: Long): HttpResponse<Unit> {
        clientService.deleteCliente(clientID = id)
        return HttpResponse.noContent()
    }

    @Put("/{clientID}")
    fun update(@PathVariable clientID: Long, @Body client: Cliente) = clientService.updateClient(clientID, client)

    @Get("/clients")
    fun listClients(@QueryValue nome: String?) = clientService.listClients(nome)
}