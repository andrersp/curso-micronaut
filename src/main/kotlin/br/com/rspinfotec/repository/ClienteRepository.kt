package br.com.rspinfotec.repository

import br.com.rspinfotec.model.Cliente
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository


@Repository
interface ClienteRepository : JpaRepository<Cliente, Long>{
}