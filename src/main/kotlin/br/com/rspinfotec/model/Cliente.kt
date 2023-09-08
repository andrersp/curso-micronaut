package br.com.rspinfotec.model

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Serdeable
@Entity
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    var nome: String,
    var documento: String,
    var endereco: String
)
