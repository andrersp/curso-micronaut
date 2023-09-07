package br.com.rspinfotec.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val nome: String,
    val documento: String,
    val endereco: String
)
